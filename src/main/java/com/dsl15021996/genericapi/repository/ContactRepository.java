package com.dsl15021996.genericapi.repository;

import com.dsl15021996.genericapi.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
