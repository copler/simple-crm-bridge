package com.dell.ems.crmbridge.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dell.ems.crmbridge.entity.ContactMapping;
import com.dell.ems.crmbridge.repository.ContactMappingRepository;
import com.dell.ems.crmbridge.service.SocialConnectService;

@Component
public class SynchronizationManager {

	@Scheduled(cron = "0/5 * * * * *")
	protected void synchronize() {
		try {
			doSynchronize();
		} catch (Throwable t) {
			logger.error("Exception during synchronization cycle", t);
		}
	}

	private void doSynchronize() {
		for (ContactMapping contactMapping : contactMappingRepository.findAll()) {
			socialConnectService.updateContact(contactMapping);
		}
	}

	@Autowired
	private SocialConnectService socialConnectService;

	@Autowired
	private ContactMappingRepository contactMappingRepository;

	private final Log logger = LogFactory.getLog(getClass());
}
