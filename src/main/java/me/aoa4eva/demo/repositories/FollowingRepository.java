package me.aoa4eva.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import me.aoa4eva.demo.models.Following;

public interface FollowingRepository extends CrudRepository<Following, Long>{
	
	Iterable <Following> findAllByFollowing(String id); 
	Iterable <Following> findAllByFollowed(String id);
}
