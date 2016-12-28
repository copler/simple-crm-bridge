package com.dell.ems.crmbridge.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.dell.ems.crmbridge.entity.ContactMapping;

@Component("socialConnectServiceFB")
public class SocialConnectServiceFB implements SocialConnectService {

	@Override
	public void updateContact(ContactMapping contactMapping) {
		logger.info("Updated contact: " + contactMapping.getUserId());
	}

	private final Log logger = LogFactory.getLog(getClass());

}
