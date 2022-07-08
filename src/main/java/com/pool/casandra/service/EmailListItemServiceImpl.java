package com.pool.casandra.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.pool.casandra.entity.EmailListItem;
import com.pool.casandra.repository.EmailListItemRepository;

@Service
public class EmailListItemServiceImpl implements EmailListItemService {

    @Autowired
    private EmailListItemRepository emailListItemRepository;

    @Override
    @Transactional
    public EmailListItem saveEmailListItem(EmailListItem emailListItem) {
        emailListItem.getKey().setTimeUuid(Uuids.timeBased());
        return emailListItemRepository.save(emailListItem);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmailListItem> getAll() {
        return emailListItemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmailListItem> findByKeyIdAndKeyLabel(String id, String label) {
        return emailListItemRepository.findByKey_IdAndKey_Label(id, label);
    }
}
