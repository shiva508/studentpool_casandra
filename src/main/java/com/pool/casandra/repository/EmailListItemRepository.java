package com.pool.casandra.repository;

import java.util.List;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.pool.casandra.entity.EmailListItem;
import com.pool.casandra.entity.EmailListItemKey;

@Repository
public interface EmailListItemRepository extends CassandraRepository<EmailListItem, EmailListItemKey> {
    List<EmailListItem> findByKey_IdAndKey_Label(String id, String label);
}
