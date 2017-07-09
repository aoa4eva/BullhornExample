package me.aoa4eva.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.aoa4eva.demo.models.BullhornPost;
import me.aoa4eva.demo.repositories.BullhornPostRepository;

@Controller
@RequestMapping("/user")
public class BullhornController {
	@Autowired 
	BullhornPostRepository bhPostRepo; 
	
	@GetMapping("/newmessage")
	public String sendNewMessage(Model m)
	{
		m.addAttribute("bhpost",new BullhornPost());
		return "/user/bullhornindex";
	}
	
	@PostMapping("/newmessage")
	public String postNewMessage(@Valid @ModelAttribute("bhpost") BullhornPost bhpost, BindingResult result)
	{
		if(result.hasErrors()){
			System.out.println(result.toString());
			return "/user/bullhornindex";
		}
		bhPostRepo.save(bhpost);
		System.out.println("Saved bhpost with mesasge "+bhpost.getMessage()+" to the database");
		return "/user/bullhornindex";
	}
	
}
