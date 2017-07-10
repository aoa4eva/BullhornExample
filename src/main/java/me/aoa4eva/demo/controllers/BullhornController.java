package me.aoa4eva.demo.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.aoa4eva.demo.models.BullhornPost;
import me.aoa4eva.demo.models.Following;
import me.aoa4eva.demo.models.User;
import me.aoa4eva.demo.repositories.BullhornPostRepository;
import me.aoa4eva.demo.repositories.FollowingRepository;
import me.aoa4eva.demo.services.UserService;

@Controller
@RequestMapping("/user")
public class BullhornController {
	@Autowired 
	BullhornPostRepository bhPostRepo; 
	
    @Autowired
    private UserService userService;
    
    @Autowired
    FollowingRepository fRepo; 
	
	@GetMapping("/newmessage")
	public String sendNewMessage(Model m)
	{
		m.addAttribute("bhpost",new BullhornPost());
		return "/user/bullhornindex";
	}
	
	@PostMapping("/newmessage")
	public String postNewMessage(@Valid @ModelAttribute("bhpost") BullhornPost bhpost, BindingResult result, Authentication currentUser)
	{

		System.out.println(bhpost.toString());
		
		if(result.hasErrors()){
			System.out.println(result.toString());
			return "/user/bullhornindex";
		}
		//Create a user object from the current logged in user's e-mail address, and use this as the reference for the 'owner' of the bullhorn post
		String msg = bhpost.getMessage(); 

		User u = userService.findByEmail(currentUser.getName()); 
		bhpost.setBhUser(u);
		bhPostRepo.save(bhpost);
		System.out.println("Saved bhpost with mesasge "+msg+" to the database for user"+u.getFirstName()+" "+u.getLastName());
		System.out.println(bhPostRepo.findAllByBhUser(u).toString());

		//Save the post to the repository, including a field for user id established in the One to Many relationship with the user 
		return "/user/bullhornindex";
	}
	
	
	
	@GetMapping("/follow/{username}")
	public @ResponseBody String followUser(@ModelAttribute("username") String username, Authentication currentUser)
	{	
		Following f = new Following();
		User u = userService.findByUsername(username); 
		System.out.println(u.getFirstName());
		if(u==null)
		{
			return "Unable to follow "+username;
		}
		f.setFollowed(u);
		f.setFollowing(userService.findByEmail(currentUser.getName()));
		
		//Set condition for following user - if user has not already been followed 
		fRepo.save(f);
		return "You are now following "+username;
	}
	
	@GetMapping("/list")
	public String getUserList(Model m)
	{
	
		Iterable <User> users = userService.findAll();
		m.addAttribute("allUsers",users);
		return "/user/list";
	}
	
}
