package com.dell.ems.crmbridge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dell.ems.crmbridge.entity.ContactMapping;
import com.dell.ems.crmbridge.repository.ContactMappingRepository;

@RestController
@RequestMapping("/resources/contacts")
public class ContactMappingController {

	@Autowired
	private ContactMappingRepository contactMappingRepository;

	@RequestMapping(method = RequestMethod.POST)
	public ContactMapping create(@RequestBody ContactMapping contact,
			HttpServletResponse response) {

		contactMappingRepository.save(contact);

		response.setStatus(HttpServletResponse.SC_CREATED);

		return contact;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ContactMapping> retrieveContacts(
			@RequestParam(value = "userId", required = false) String userId) {

		List<ContactMapping> contacts = new ArrayList<ContactMapping>();

		if (userId != null) {

			contacts = contactMappingRepository.findByUserId(userId);
		} else {

			for (ContactMapping c : contactMappingRepository.findAll()) {
				contacts.add(c);
			}
		}

		return contacts;
	}

}
