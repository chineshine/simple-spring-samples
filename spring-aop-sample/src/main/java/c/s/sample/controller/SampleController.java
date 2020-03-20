package c.s.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import c.s.sample.exception.AuthException;
import c.s.sample.exception.ErrorCode;
import c.s.sample.exception.SampleException;
import c.s.sample.service.SampleService;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
@RestController
public class SampleController {
	
	private @Autowired SampleService sampleService;

	@GetMapping("/doget")
	public String doGet(String name) {
		if ("1".equals(name)) {
			throw new SampleException(ErrorCode.requestInternalError, "这个错走 restControllerAdvice");
		}
		if("2".equals(name)) {
			throw new RuntimeException("这个错走 spring 内部的 `/error` 接口");
		}
		return "success";
	}
	
	@GetMapping("/doauth")
	public String doAuth(String username,String password){
		if(!"admin".equals(username)) {
			throw new AuthException(ErrorCode.usernameNotExist, "用户名不存在");
		}
		if(!"admin".equals(password)) {
			throw new AuthException(ErrorCode.passwordError, "用户密码错误");
		}
		return "success";
	}
	
	@PostMapping("/dopost")
	public String doPost() {
		//使用 get 方式请求该请求,测试 method_not_allow
		return "success";
	}
	
	@GetMapping("/doservice")
	public String doService() {
		// 测试 service 报错是否会被捕捉
		sampleService.doService();
		return "success";
	}
	
	@GetMapping("/doaop")
	public String doAop() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "success";
	}

}
