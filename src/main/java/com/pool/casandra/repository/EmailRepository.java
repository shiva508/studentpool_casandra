package com.pool.casandra.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.pool.casandra.entity.Email;

@Repository
public interface EmailRepository extends CassandraRepository<Email, UUID> {
    public Optional<Email> findById(UUID id);
}
