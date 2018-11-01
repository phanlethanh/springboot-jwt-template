package com.thanhpl.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thanhpl.jwt.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	@Query(value = "SELECT * FROM public.m_user \r\n" + 
			"WHERE username = :username\r\n", 
			nativeQuery = true)
	User findByUsername(@Param("username") String username);
	
	@Query(value = "SELECT max(to_number(user_id, '9999999999')) + 1 FROM public.m_user", 
			nativeQuery = true)
	Long getNextId();
}
