package com.pool.casandra.controller.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.casandra.entity.Email;
import com.pool.casandra.service.EmailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/createemail")
    public Email saveEmail(@RequestBody Email email) {
        return emailService.saveEmail(email);
    }

    @GetMapping("/getbyuuid/{id}")
    public ResponseEntity<?> getEmailById(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);
        Email email = emailService.getEmailById(uuid);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }

    @GetMapping("/allemails")
    public ResponseEntity<?> getEmaila() {

        List<Email> emails = emailService.getEmails();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

}
