package com.pool.casandra.controller.view;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pool.casandra.entity.Email;
import com.pool.casandra.entity.EmailListItem;
import com.pool.casandra.entity.Folder;
import com.pool.casandra.service.EmailListItemService;
import com.pool.casandra.service.EmailService;
import com.pool.casandra.service.FolderService;

@Controller
public class EmailViewController {

        @Autowired
        private FolderService folderService;

        @Autowired
        private EmailService emailService;

        @GetMapping("/viewemail/{id}")
        public String emailPage(Model model, @PathVariable("id") String id) {
                UUID uuid = UUID.fromString(id);
                List<Folder> userFolders = folderService.findByUserid("dasarishiva.d2@gmail.com");

                List<Folder> defaultFolders = Arrays.asList(
                                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Inbox").setColor("white"),
                                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Sent Items")
                                                .setColor("green"),
                                new Folder().setUserid("dasarishiva1@gmail.com").setLable("Impartant").setColor("red"));
                Email email = emailService.getEmailById(uuid);
                String toAdderess = "";
                if (null != email && !email.getTo().isEmpty()) {
                        toAdderess = String.join(", ", email.getTo());
                }

                model.addAttribute("userFolders", userFolders);
                model.addAttribute("defaultFolders", defaultFolders);
                model.addAttribute("email", email);
                model.addAttribute("toAdderess", toAdderess);
                return "email-page";

        }
}
