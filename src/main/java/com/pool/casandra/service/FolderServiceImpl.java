package com.pool.casandra.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pool.casandra.entity.Folder;
import com.pool.casandra.repository.FolderRepository;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderRepository folderRepository;

    @Override
    @Transactional
    public Folder createFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    @Override
    @Transactional
    public List<Folder> findByUserid(String userid) {
        List<Folder> folders = folderRepository.findByUserid(userid);
        return folders;
    }
}
