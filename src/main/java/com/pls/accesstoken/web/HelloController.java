package com.pls.accesstoken.web;

import com.pls.accesstoken.model.Result;
import com.pls.accesstoken.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by 81046 on 2018-07-20
 */
@RestController
@RequestMapping("/hello")
@Api("HomeController相关的api")
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * 获取配置文件中的属性值
     */
    @Value("${my.author.name}")
    private String author;

    @ApiOperation(value = "测试访问", notes = "返回指定字符串")
    @GetMapping("/say")
    public Result say(){
        LOGGER.info("{} -- This is a primary with logback., Current time {}.", author, new Date());
        LOGGER.trace("This level is TRACE.");
        LOGGER.debug("This level is DEBUG.");
        LOGGER.debug("This level is DEBUG.", LOGGER.isDebugEnabled());
        LOGGER.info("This level is INFO.");
        LOGGER.info("isInfoEnabled:" + LOGGER.isInfoEnabled());
        LOGGER.warn("This level is WARN.");
        LOGGER.error("This level is ERROR.");
        return ResultUtil.success("hello swagger 2 "+author);
    }
}
