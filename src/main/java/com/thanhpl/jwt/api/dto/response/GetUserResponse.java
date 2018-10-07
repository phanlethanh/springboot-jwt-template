package com.thanhpl.jwt.api.dto.response;

import com.thanhpl.jwt.api.dto.UserDto;

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
public class GetUserResponse extends BaseResponse {
	private UserDto data;
}
