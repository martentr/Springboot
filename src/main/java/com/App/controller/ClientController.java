package com.App.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    // Add methods to handle client management here
    
    @GetMapping
    public String showClientList() {
        // Display the list of clients for the logged-in user
        return "client/list";
    }

    @GetMapping("/add")
    public String showAddClientForm() {
        // Display the form to add a new client
        return "client/add";
    }

    @PostMapping("/add")
    public String addClient() {
        // Process client addition and save to the database
        return "redirect:/clients";
    }

    @GetMapping("/edit/{clientId}")
    public String showEditClientForm() {
        // Display the form to edit an existing client
        return "client/edit";
    }

    @PostMapping("/edit/{clientId}")
    public String editClient() {
        // Process client edit and update in the database
        return "redirect:/clients";
    }
}
