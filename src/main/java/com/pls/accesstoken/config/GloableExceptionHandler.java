package com.pls.accesstoken.config;

import com.pls.accesstoken.util.HttpAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理
 * @author 81046
 *
 */
@ControllerAdvice
public class GloableExceptionHandler {

	private final static Logger LOGGER = LoggerFactory.getLogger(GloableExceptionHandler.class);
	
	/**
	 * 这只是返回到后台
	 */
	/*@ExceptionHandler(value=Exception.class)
	public void defaultErrorHandler1() {
		System.out.println("******defaultErrorHandler1****");
	}*/
	
	/**
	 * 返回到前端 字符串         注意这些方法不能同时用，只能用一个哦
	 */
	/*@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public String defaultErrorHandler2() {
		System.out.println("******defaultErrorHandler2****");
		return "系统错误，请联系管理员！";
	}*/
	
	/**
	 * 错误信息返回到页面
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public ModelAndView defaultErrorHandler3(Exception e) {
		System.out.println("******defaultErrorHandler3****");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/exception");
		//具体的情况，在这里处理，返回客户看得懂的提示
		mv.addObject("messages",e.getMessage());
		LOGGER.error("【系统异常】{}",e);
		return mv;
	}
}
