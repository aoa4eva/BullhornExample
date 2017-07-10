package me.aoa4eva.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.aoa4eva.demo.models.BullhornPost;
import me.aoa4eva.demo.models.User;
import me.aoa4eva.demo.repositories.BullhornPostRepository;

@Service
public class BhPostService {
	
	@Autowired
	BullhornPostRepository bhPostrepo; 
	
	
	public Iterable <BullhornPost> allPosts(User u)
	{
		return bhPostrepo.findAllByBhUser(u);
	}

}
