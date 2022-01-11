package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import com.neo.demo.dao.UserRepository;
import com.neo.demo.entity.User;
import com.neo.demo.service.UserService;

@SpringBootTest
class DemoApplicationTests {

	@Mock
	UserRepository repo;

	User saveuser = null;

	@Autowired
	UserService service;

	@BeforeEach
	public void setUp() {
		saveuser = new User(9, "nanda", "yamba", "02-07-1995","05-11-2020","nanda@email.com","hyd","997898",false);
	}

	@Test
	@Description(value = "saveUserSet")
	void saveUserEntityTest() {
		when(repo.save(saveuser)).thenReturn(saveuser);
		assertEquals("nanda", service.addUser(saveuser).getFirstName());

	}

	@Test
	@Description("Test getBy id Service")
	void getuserbyID() {

		when(repo.getById(1)).thenReturn(
				new User(5, "nanda", "yamba", "02-07-1995","05-11-2020","nanda@email.com","hyd","997898",false));
		assertEquals(Optional.empty(), service.findUserById(1));
	}

	@Test
	@Description("Test getByUsername service")
	void getUserByName() {
		List<User> userlist = new ArrayList<User>();
		userlist.add(
				new User(9, "nanda", "yamba", "02-07-1995","05-11-2020","nanda@email.com","hyd","997898",false));
		when(repo.getById(anyInt())).thenReturn(
				new User(9, "nanda", "yamba", "02-07-1995","05-11-2020","nanda@email.com","hyd","997898",false));
		assertEquals("517291", service.findUserByfirstName("nanda").get(0).getPincode());
	}

	@Test
	void UpdateUser() {
		User user = new User(9, "nanda", "yamba", "02-07-1995","05-11-2020","nanda@email.com","hyd","997898",false);
		when(repo.save(user)).thenReturn(user);
		assertEquals("yamba", service.addUser(saveuser).getFirstName());

	}

	@Test
	void DeleteUser() {
		User user = new User(9, "nanda", "yamba", "02-07-1995","05-11-2020","nanda@email.com","hyd","997898",false);

		repo.save(user);
		assertEquals("user deleted ", service.userSoftDelete(11));
	}

}
