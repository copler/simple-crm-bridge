package com.dell.ems.crmbridge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dell.ems.crmbridge.entity.ContactMapping;

public interface ContactMappingRepository extends CrudRepository<ContactMapping, Integer> {

    List<ContactMapping> findByUserId(String userId);

}
