package com.pool.casandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.pool.casandra.entity.Folder;

//@Repository
public interface FolderRepository extends CassandraRepository<Folder, String> {
    public List<Folder> findByUserid(String userid);
}
