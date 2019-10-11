package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.ICustomerRepository;
import com.laptrinhjavaweb.repository.IUserRepository;
import com.laptrinhjavaweb.repository.impl.CustomerRepository;
import com.laptrinhjavaweb.repository.impl.UserRepository;
import com.laptrinhjavaweb.service.ICustomerservice;
import com.laptrinhjavaweb.service.IUserservice;

public class CustomerService implements ICustomerservice {
	private ICustomerRepository customerRepository;
	private CustomerConverter customerConverter;

	public CustomerService() {
		customerRepository = (ICustomerRepository) new CustomerRepository();
		customerConverter = new CustomerConverter();
	}

	private Map<String, Object> convertToMapProperties(CustomerSearchBuilder fieldSearch) {
		Map<String, Object> properties = new HashMap<>();
		try {
			Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				if (!field.getName().startsWith("staffId")) {
					field.setAccessible(true);// cap quyen truy cap cho private
					if (field.get(fieldSearch) instanceof String) {
						if (field.getName().equals("phone")) {
							if (field.get(fieldSearch) != null
									&& StringUtils.isNotEmpty((String) field.get(fieldSearch))) {
								properties.put(field.getName().toLowerCase(),
										Integer.parseInt((String) field.get(fieldSearch)));

							}
						}
						properties.put(field.getName().toLowerCase(), field.get(fieldSearch));
					}
				}
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return properties;
	}

	@Override
	public List<CustomerDTO> findAll(CustomerSearchBuilder fieldSearch, Pageable pageable) {
		// Convert theo map
		Map<String, Object> properties = convertToMapProperties(fieldSearch);
		List<CustomerEntity> customerEntities = customerRepository.findAll(properties, pageable, fieldSearch);
		return customerEntities.stream().map(item -> customerConverter.convertToDTO(item)).collect(Collectors.toList());
	}

}
