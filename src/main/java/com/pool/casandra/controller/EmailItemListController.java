package com.pool.casandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.casandra.entity.EmailListItem;
import com.pool.casandra.service.EmailListItemService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailItemListController {
    @Autowired
    private EmailListItemService emailListItemService;

    @PostMapping("/save")
    public EmailListItem saveEmailListItem(@RequestBody EmailListItem emailListItem) {
        return emailListItemService.saveEmailListItem(emailListItem);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmailItems() {
        List<EmailListItem> emailListItems = emailListItemService.getAll();
        return new ResponseEntity<>(emailListItems, HttpStatus.OK);
    }
}
