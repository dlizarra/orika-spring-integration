package com.dlizarra.orika.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dlizarra.orika.config.AppConfig;
import com.dlizarra.orika.dto.UserDto;
import com.dlizarra.orika.entity.User;
import com.dlizarra.orika.mock.MockUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class OrikaBeanMapperTest {

	@Autowired
	OrikaBeanMapper mapper;

	@Test
	public void shouldMapUsertoUserDto() {
		// Given
		User user = MockUtils.mockUser();

		// When
		UserDto userDto = mapper.map(user, UserDto.class);

		// Then
		Assert.assertEquals(userDto.getId(), "1");
		Assert.assertEquals(userDto.getFullName(), "Pep Guardiola");
		Assert.assertEquals(userDto.getAddress(), "25, Barcelona St.");
	}

}
