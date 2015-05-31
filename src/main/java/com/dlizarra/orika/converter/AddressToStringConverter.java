package com.dlizarra.orika.converter;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

import org.springframework.stereotype.Component;

import com.dlizarra.orika.entity.Address;

/**
 * Converter exposed as a Spring Bean which tells Orika how an Address object
 * should be converted to a String.
 * 
 * @author dlizarra
 *
 */
@Component
public class AddressToStringConverter extends CustomConverter<Address, String> {

	public String convert(Address sourceAddress, Type<? extends String> destinationType) {
		String address = "";
		if (sourceAddress != null) {
			address = sourceAddress.getNumber() != null ? address + sourceAddress.getNumber() + ", " : "N/A, ";
			address = sourceAddress.getStreet() != null ? address + sourceAddress.getStreet() : "N/A";
		}
		return address;
	}
}
