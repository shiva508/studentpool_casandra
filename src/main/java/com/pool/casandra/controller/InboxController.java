package com.pool.casandra.controller;

import java.util.Arrays;
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
    public String homePage(Model model) {
        List<Folder> folders=folderService.findByUserid("dasarishiva1@gmail.com");
        model.addAttribute("folders", folders);
        return "inbox-page";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Folder> defaultFolders=Arrays.asList(
            new Folder().setUserid("dasarishiva1@gmail.com").setLable("Inbox").setColor("white"),
            new Folder().setUserid("dasarishiva1@gmail.com").setLable("Sent Items").setColor("green"),
            new Folder().setUserid("dasarishiva1@gmail.com").setLable("Impartant").setColor("red")
            );

        List<Folder> userFolders=Arrays.asList(
            new Folder().setUserid("dasarishiva1@gmail.com").setLable("Inbox").setColor("white"),
            new Folder().setUserid("dasarishiva1@gmail.com").setLable("Sent Items").setColor("green"),
            new Folder().setUserid("dasarishiva1@gmail.com").setLable("Impartant").setColor("red")
            );
        model.addAttribute("userFolders", userFolders);
        model.addAttribute("defaultFolders", defaultFolders);
        return "index";
    }
}
