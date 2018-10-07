package com.thanhpl.jwt.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thanhpl.jwt.api.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	
	@Query(value = "SELECT r.role_name FROM m_user_role ur\r\n" + 
			"JOIN s_role r ON (r.role_id = ur.role_id)\r\n" + 
			"WHERE ur.user_id = :userId", 
			nativeQuery = true)
	List<String> getRoleNames(@Param("userId") String userId);
}
