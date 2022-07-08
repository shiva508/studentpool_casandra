package com.pool.casandra.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pool.casandra.entity.Folder;
import com.pool.casandra.service.FolderService;

@RestController
@RequestMapping("/api/v1/folder")
public class FolderController {

    @Autowired
    private FolderService folderService;

    @PostMapping("/create")
    public ResponseEntity<?> createFolder(@RequestBody Folder folder) {
        Folder savedFolder = folderService.createFolder(folder);
        return new ResponseEntity<>(savedFolder, HttpStatus.CREATED);
    }

    @GetMapping("/userid/{userid}")
    public ResponseEntity<?> findByUserid(@PathVariable("userid") String userid) {
        List<Folder> folders = folderService.findByUserid(userid);
        return new ResponseEntity<>(folders, HttpStatus.OK);
    }

}
