package com.dsl15021996.genericapi.service.interfaces;

import java.util.List;

import com.dsl15021996.genericapi.model.Contact;


public interface IContactService {
    
    public Contact createContact(Contact contact);
    public Contact findByIdContact(Long id);
    public List<Contact> findAllContact();
}
