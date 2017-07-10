package me.aoa4eva.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import me.aoa4eva.demo.models.BullhornPost;
import me.aoa4eva.demo.models.User;

public interface BullhornPostRepository extends CrudRepository<BullhornPost, Long> {
	
	List <BullhornPost> findAllByBhUser(User u);

}
