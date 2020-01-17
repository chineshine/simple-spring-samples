package c.s.sample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @date 2019年12月6日
 *
 */
@RestController
public class RestfulController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/api/users/me")
    public ResponseEntity<Object> profile() 
    {
        //Build some dummy data to return for testing
        Object user =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        return ResponseEntity.ok(user);
    }
}
