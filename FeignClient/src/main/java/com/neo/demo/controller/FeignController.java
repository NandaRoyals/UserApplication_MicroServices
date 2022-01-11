package com.neo.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.neo.demo.util.FeignServiceUtil;

@RestController
@RequestMapping("/demo")
public class FeignController {

	@Autowired
	private FeignServiceUtil feignServiceUtil;

	@PostMapping("/addUser")
	public String saveUser() {
		return feignServiceUtil.getsaveUser();
	}

	@GetMapping("getById")
	public String getUserById() {
		return feignServiceUtil.getUserById();
	}

	@PostMapping("updateuserId")
	public String UpdateUser() {
		return feignServiceUtil.UpdateUser();
	}

	@GetMapping("getByName")
	public String getUseByfirstName() {
	return feignServiceUtil.getUseByfirstName();
}

	@GetMapping("/getAllUser")
	public String SortByDateofJoinAndDateofBirth() {
		return feignServiceUtil.SortByDateofJoinAndDateofBirth();
	}

	@DeleteMapping("delete/{id}")
	public String softDeleteUser() {
		return feignServiceUtil.softDeleteUser();
	}

}
