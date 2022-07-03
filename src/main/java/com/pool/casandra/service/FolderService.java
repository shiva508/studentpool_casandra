package com.pool.casandra.service;

import java.util.List;

import com.pool.casandra.entity.Folder;

public interface FolderService {
    public Folder createFolder(Folder folder);
    public List<Folder> findByUserid(String userid);
}
