package com.thanhpl.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thanhpl.jwt.api.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	
	@Query(value = "SELECT privileges FROM public.s_role \r\n" + 
			"WHERE role_id = :roleId", 
			nativeQuery = true)
	String getPrivileges(@Param("roleId") String roleId);
}
