package com.pool.casandra.service;

import java.util.List;
import java.util.UUID;

import com.pool.casandra.entity.Email;

public interface EmailService {
    public Email saveEmail(Email email);

    public Email getEmailById(UUID id);

    public List<Email> getEmails();
}
