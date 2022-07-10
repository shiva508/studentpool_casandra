package com.pool.casandra.controller.view;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pool.casandra.entity.EmailListItem;
import com.pool.casandra.entity.Folder;
import com.pool.casandra.service.EmailListItemService;
import com.pool.casandra.service.FolderService;

@Controller
public class InboxViewController {

        @Autowired
        private FolderService folderService;

        @Autowired
        private EmailListItemService emailListItemService;

        @GetMapping("/home")
        public String homePage(Model model) {
                List<Folder> userFolders = folderService.findByUserid("dasarishiva.d2@gmail.com");
                List<EmailListItem> emailListItems = emailListItemService.findByKeyIdAndKeyLabel(
                                "dasarishiva.d2@gmail.com",
                                "Draft ");
                List<Folder> defaultFolders = Arrays.asList(
                                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Inbox").setColor("white"),
                                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Sent Items")
                                                .setColor("green"),
                                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Impartant").setColor("red"));

                model.addAttribute("emailListItems", emailListItems);
                model.addAttribute("userFolders", userFolders);
                model.addAttribute("defaultFolders", defaultFolders);
                return "inbox-page";
        }

        @GetMapping("/index")
        public String index(Model model, @RequestParam(required = false, name = "folder") String folder) {
                if (!StringUtils.hasText(folder)) {
                        folder = "Draft";
                }
                List<Folder> userFolders = folderService.findByUserid("dasarishiva.d2@gmail.com");
                List<EmailListItem> emailListItems = emailListItemService.findByKeyIdAndKeyLabel(
                                "dasarishiva.d2@gmail.com",
                                folder);
                List<Folder> defaultFolders = Arrays.asList(
                                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Inbox").setColor("white"),
                                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Sent Items")
                                                .setColor("green"),
                                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Impartant").setColor("red"));

                model.addAttribute("emailListItems", emailListItems);
                model.addAttribute("userFolders", userFolders);
                model.addAttribute("defaultFolders", defaultFolders);
                model.addAttribute("foldName", folder);
                return "index";
        }
}
