package com.pool.casandra.service;

import java.util.List;

import com.pool.casandra.entity.EmailListItem;

public interface EmailListItemService {
    public EmailListItem saveEmailListItem(EmailListItem emailListItem);

    public List<EmailListItem> getAll();

    List<EmailListItem> findByKeyIdAndKeyLabel(String id, String label);
}
