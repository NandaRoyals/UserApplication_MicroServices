package com.neo.demo.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value="fidenDemo",url="http://localhost:8761/user")
public interface FeignServiceUtil {
	
	@PostMapping("/newUser")
	String getsaveUser();
	
	
	@GetMapping("getById/{id}")
    String getUserById();
	
	@PostMapping("updateuser/{id}")
	String UpdateUser();
	
	@GetMapping("getByName/{name}")
	String getUseByfirstName();
	
	@GetMapping("/getAllUser")
	String SortByDateofJoinAndDateofBirth();
	
	@DeleteMapping("delete/{id}")
	String softDeleteUser();
	
	
	
	

}
