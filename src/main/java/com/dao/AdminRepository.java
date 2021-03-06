package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bean.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{

	@Modifying
	@Query("update Admin as a set a.pass = :password where a.email = :email")
	int changePasswrd(@Param("email") String  email, @Param("password") String password);
	
	@Query(value = "select * from admin where email = :Email", nativeQuery = true)
	Admin findAdmin(@Param("Email") String Email);
}
