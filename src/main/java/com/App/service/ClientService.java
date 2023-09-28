package com.App.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.entity.Client;
import com.App.entity.User;
import com.App.repository.ClientRepository;


@Service
public class ClientService {
    private final ClientRepository clientRepository;

    //@Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Add methods for client-related business logic here

    public Client addClient(Client client, User user) {
        // Implement the logic to add a client
        client.setUser(user);
        // You may perform validation or other operations here
        return clientRepository.save(client);
    }

    public Client editClient(Long clientId, Client updatedClient, User user) {
        // Ensure that the client exists and belongs to the user
        Optional<Client> existingClientOptional = clientRepository.findById(clientId);
        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();
            
            // Check if the client belongs to the user
            if (existingClient.getUser().equals(user)) {
                // Update client attributes as needed
                existingClient.setName(updatedClient.getName());
                existingClient.setEmail(updatedClient.getEmail());
                
                // Implement any validation logic here before saving
                
                return clientRepository.save(existingClient);
            } else {
                // Client does not belong to the user
                throw new IllegalArgumentException("Client does not belong to the user.");
            }
        } else {
            // Client not found
            throw new IllegalArgumentException("Client not found.");
        }
    }

    // Get all clients for a specific user
    public List<Client> getClientsForUser(User user) {
        return clientRepository.findByUser(user);
    }
}