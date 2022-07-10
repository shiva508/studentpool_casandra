package com.pool.casandra.controller.view;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pool.casandra.entity.Folder;
import com.pool.casandra.service.FolderService;

@Controller
public class ComposeViewController {

    @Autowired
    private FolderService folderService;

    @GetMapping("/compose")
    public String getComposePage(Model model) {

        List<Folder> userFolders = folderService.findByUserid("dasarishiva.d2@gmail.com");

        List<Folder> defaultFolders = Arrays.asList(
                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Inbox").setColor("white"),
                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Sent Items")
                        .setColor("green"),
                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Impartant").setColor("red"));

        model.addAttribute("userFolders", userFolders);
        model.addAttribute("defaultFolders", defaultFolders);
        return "compose-page";
    }
}
