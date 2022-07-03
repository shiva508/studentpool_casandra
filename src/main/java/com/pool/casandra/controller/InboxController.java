package com.pool.casandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pool.casandra.entity.Folder;
import com.pool.casandra.service.FolderService;

@Controller
public class InboxController {

    @Autowired
    private FolderService folderService;

    @GetMapping("/home")
    public String homePge(Model model) {
        List<Folder> folders=folderService.findByUserid("dasarishiva1@gmail.com");
        model.addAttribute("folders", folders);
        return "inbox-page";
    }
}
