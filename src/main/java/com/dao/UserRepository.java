package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User u WHERE u.email = :email and u.password = :password")
	User signIn(@Param("email") String email, @Param("password") String password);
	
	@Query(value = "SELECT * FROM USER WHERE NAME LIKE %?1%", nativeQuery = true)
	List<User> searchUser(String name);
}
