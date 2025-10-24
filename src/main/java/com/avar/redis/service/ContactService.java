package com.avar.redis.service;

import com.avar.redis.entity.ContactEntity;
import com.avar.redis.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

  private final ContactRepository contactRepository;

  @Cacheable(value = "contacts")
  public ContactEntity getContactById(Long id) {
    return contactRepository.findById(id).orElse(null);
  }

  public ContactEntity saveContact(ContactEntity contact) {
    return contactRepository.save(contact);
  }

  @CachePut(value = "contacts", key = "#contact.id")
  public ContactEntity updateContact(ContactEntity contact) {
    var existingContact = contactRepository.findById(contact.getId());
    if (existingContact.isPresent()) {
      return contactRepository.save(contact);
    }
    return null;
  }


}
