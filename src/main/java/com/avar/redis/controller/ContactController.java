package com.avar.redis.controller;

import com.avar.redis.entity.ContactEntity;
import com.avar.redis.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

  private final ContactService contactService;

  @GetMapping("/{contactId}")
  public ResponseEntity<ContactEntity> getContactById(@PathVariable Long contactId) {
    var contact = contactService.getContactById(contactId);
    return ResponseEntity.ok(contact);
  }

  @PostMapping
  public ResponseEntity<ContactEntity> saveContact(@RequestBody ContactEntity contact) {
    return ResponseEntity.ok(contactService.saveContact(contact));
  }

  @PutMapping
  public ResponseEntity<ContactEntity> updateContact(@RequestBody ContactEntity contact) {
    return ResponseEntity.ok(contactService.updateContact(contact));
  }

}
