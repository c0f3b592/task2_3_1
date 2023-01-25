package org.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.test.model.User;
import org.test.service.UserService;
import java.util.List;

@Controller
public class IndexController {
	
	private final UserService service;
	
	public IndexController(UserService service) {
		this.service = service;
	}
	
	@GetMapping(value = "/")
	public String printWelcome() {
		return "index";
	}
	
	@GetMapping(value = "/create")
	public String createTable() {
		service.add(new User("имя1", "фамилия1", (byte) 42, "почта1"));
		service.add(new User("имя2", "фамилия2", (byte) 42, "почта2"));
		service.add(new User("имя3", "фамилия3", (byte) 42, "почта3"));
		service.add(new User("имя4", "фамилия4", (byte) 42, "почта4"));
		service.add(new User("имя5", "фамилия5", (byte) 42, "почта5"));
		return "index";
	}
	
	@GetMapping(value = "/users")
	public String printUsers(ModelMap model) {
		List<User> users = service.getUserList();
		model.addAttribute("users", users);
		return "users";
	}
	
	@GetMapping(value = "/userinfo", params = {"newuser"})
	public String addUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("action", "new");
		return "userinfo";
	}
	
	@GetMapping(value = "/userinfo", params = {"id"})
	public String updateUser(ModelMap model, @RequestParam("id") long id) {
		User user = service.getUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("action", "update");
		return "userinfo";
	}
	
	@PostMapping(value = "/userinfo", params = {"save"})
	public String saveUserInfo(@ModelAttribute("user") User user) {
		service.add(user);
		return "redirect:/users";
	}
	
	@PostMapping(value = "/userinfo", params = {"update"})
	public String updateUserInfo(@ModelAttribute("user") User user) {
		service.update(user);
		return "redirect:/users";
	}
	
	@DeleteMapping(value = "/users", params = {"id"})
	public String deleteUser(@RequestParam("id") long id) {
		service.deleteUser(id);
		return "redirect:/users";
	}
	
}