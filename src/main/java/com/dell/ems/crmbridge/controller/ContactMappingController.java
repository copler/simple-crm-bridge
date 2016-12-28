package com.dell.ems.crmbridge.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dell.ems.crmbridge.entity.ContactMapping;
import com.dell.ems.crmbridge.repository.ContactMappingRepository;

@RestController
@RequestMapping("/resources/contacts")
public class ContactMappingController {

	@Autowired
	private ContactMappingRepository contactMappingRepository;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ContactMapping addMapping(@RequestBody ContactMapping contact,
			HttpServletResponse response) {

		contactMappingRepository.save(contact);

		response.setStatus(HttpServletResponse.SC_NO_CONTENT);

		return contact;
	}

	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ContactMapping delMapping(@RequestBody ContactMapping contact,
			HttpServletResponse response) {

		contactMappingRepository.delete(contactMappingRepository.findByUserId(contact.getUserId()));

		response.setStatus(HttpServletResponse.SC_NO_CONTENT);

		return contact;
	}

}
