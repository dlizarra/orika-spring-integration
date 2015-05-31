package com.dlizarra.orika.mapper.custom;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

import org.springframework.stereotype.Component;

import com.dlizarra.orika.dto.UserDto;
import com.dlizarra.orika.entity.User;

/**
 * Custom mapper exposed as a Spring Bean used to customize the mapping between a User and a UserDto.
 * 
 * @author dlizarra
 */
@Component
public class UserUserDtoMapper extends CustomMapper<User, UserDto> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mapAtoB(User user, UserDto userDto, MappingContext context) {
		userDto.setFullName(user.getName() + " " + user.getLastName());
	}

}
