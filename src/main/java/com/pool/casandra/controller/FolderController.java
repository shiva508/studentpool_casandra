package com.pool.casandra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pool.casandra.entity.Folder;
import com.pool.casandra.service.FolderService;

@RestController("/api/v1/folder")
public class FolderController {
    
    @Autowired
    private FolderService folderService;

    @PostMapping("/create")
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder) {
        Folder savedFolder=folderService.createFolder(folder);
        return new ResponseEntity<>(savedFolder, HttpStatus.CREATED);
    }
}
