package com.thanhpl.jwt.api.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thanhpl.jwt.api.model.key.UserRoleKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="m_user_role", schema = "public")
public class UserRole {
	
	@EmbeddedId
	private UserRoleKey key;
	
	private Date createTime;
	private Date updateTime;
}
