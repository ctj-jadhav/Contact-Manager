package com.example.contactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.contactmanager.model.Contact;
import com.example.contactmanager.repository.ContactRepository;

@Controller
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "index";
    }

    @PostMapping("/addContact")
    public String addContact(@RequestParam String name, @RequestParam String email) {
        Contact contact = new Contact(name, email);
        contactRepository.save(contact);
        return "redirect:/";
    }
}
