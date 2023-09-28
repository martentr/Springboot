package com.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
    
    public void registerUser(User user); //{
        //
        //@Autowired
        //private PasswordEncoder passwordEncoder;
    
        //String encodedPassword = passwordEncoder.encode(user.getPassword());
        //user.setPassword(encodedPassword);
        //userRepository.save(user);
    //}
   
    // Custom query methods (if needed) can be added here
}
