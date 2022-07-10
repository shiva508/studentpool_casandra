package com.pool.casandra.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.casandra.entity.Email;
import com.pool.casandra.model.exception.RecordNotFoundException;
import com.pool.casandra.repository.EmailRepository;
import com.pool.casandra.util.StudentpoolConstants;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    @Transactional
    public Email saveEmail(Email email) {
        Email savedEmail = emailRepository.save(email);
        return savedEmail;
    }

    @Override
    @Transactional
    public Email getEmailById(UUID id) {
        Optional<Email> optionalEmail = emailRepository.findById(id);
        Email email = null;
        if (optionalEmail.isPresent()) {
            email = optionalEmail.get();
        } else {
            throw new RecordNotFoundException(StudentpoolConstants.EMAIL_NOT_FOUND_MSG);
        }
        return email;
    }

    @Override
    @Transactional
    public List<Email> getEmails() {
        return emailRepository.findAll();
    }

}
