package com.pls.accesstoken;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
//定时器需要导入
@EnableScheduling
//mapper/dao需要导入
@MapperScan(basePackages = "com.pls.accesstoken.dao")
//访问接口文档  http://localhost:8087/swagger-ui.html
@EnableSwagger2
public class AccesstokenApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(AccesstokenApplication.class, args);
	}

	/**
	 * 这里是为了使用阿里的fastjson
	 *
	 */
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		FastJsonConfig fastConfig=new FastJsonConfig();
		fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastConfig);
		converters.add(fastConverter);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(
				"classpath:/static/");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations(
				"classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations(
				"classpath:/META-INF/resources/webjars/");
		super.addResourceHandlers(registry);
	}

	/**
	 * 配置servlet处理
	 */
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.pls.accesstoken.web"))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 这里配置swagger的title和描述等
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//页面标题
				.title("定时获取AccessToken项目")
				.description("请按照接口说明输入输出参数")
				.termsOfServiceUrl("http://www.joffro.com/")
				.version("1.0")
				.build();
	}
}
