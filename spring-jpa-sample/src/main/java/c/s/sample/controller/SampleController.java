package c.s.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import c.s.sample.model.Users;
import c.s.sample.repository.UsersRepository;

/**
 * @author chineshine
 * @date 2019年12月25日
 *
 */
@RestController
@RequestMapping("/")
public class SampleController {

	private @Autowired UsersRepository usersRepository;
	
	@GetMapping
	public String index() {
		return "this is the index data";
	}

	@GetMapping("/users")
	public List<Users> users(){
		return usersRepository.findAll();
	}
	
}
