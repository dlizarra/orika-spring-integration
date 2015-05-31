package com.dlizarra.orika.mock;

import com.dlizarra.orika.entity.Address;
import com.dlizarra.orika.entity.User;

public final class MockUtils {

	private MockUtils() {
		// Non-instantiable class
	}

	public static User mockUser() {
		User user = new User();
		user.setId(1);
		user.setName("Pep");
		user.setLastName("Guardiola");
		Address address = new Address();
		address.setNumber(25);
		address.setStreet("Barcelona St.");
		user.setAddress(address);

		return user;
	}
}
