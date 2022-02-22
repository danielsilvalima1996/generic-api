package com.dsl15021996.genericapi.service;

import java.util.List;

import com.dsl15021996.genericapi.model.Contact;
import com.dsl15021996.genericapi.repository.ContactRepository;
import com.dsl15021996.genericapi.service.interfaces.IContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactService implements IContactService {

    @Autowired
	ContactRepository repository;

    @Override
    public Contact createContact(Contact contact) {
        Contact dbContact = repository.save(contact);
        return dbContact;
    }

    @Override
    public Contact findByIdContact(Long id) {
        var contact = repository.findById(id);
		if(contact.isPresent())
			return contact.get();
		return null;	
    }

    @Override
    public List<Contact> findAllContact() {
        return repository.findAll();
    }
    
}
