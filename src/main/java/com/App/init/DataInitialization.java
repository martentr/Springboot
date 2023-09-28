package com.App.init;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.App.entity.Client;
import com.App.entity.User;
import com.App.repository.ClientRepository;
import com.App.repository.UserRepository;

@Component
public class DataInitialization implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    //@Autowired
    public DataInitialization(UserRepository userRepository, ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Insert three user records
        User user1 = new User("user1", passwordEncoder.encode("password1"));
        User user2 = new User("user2", passwordEncoder.encode("password2"));
        User user3 = new User("user3", passwordEncoder.encode("password3"));

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        // Insert some initial client data
        Client client1 = new Client("Client 1", "client1@example.com", user1);
        Client client2 = new Client("Client 2", "client2@example.com", user2);
        Client client3 = new Client("Client 3", "client3@example.com", user3);

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
    }
}