package com.App.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
//import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.App.entity.User;

public class CustomUserDetails implements UserDetails{
    
    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }


    @Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    // Implement to return the user's authorities/roles
    // You can load roles from your database here
    // Example: return user.getRoles();
    return user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());
}


    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement account expiration logic here
        return true; // Return true if the account is not expired
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement account locking logic here
        return true; // Return true if the account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement credentials expiration logic here
        return true; // Return true if the credentials are not expired
    }

    @Override
    public boolean isEnabled() {
        // Implement account enabled/disabled logic here
        return true; // Return true if the account is enabled
    }

    // Implement other UserDetails methods (isEnabled, isAccountNonExpired, etc.) as needed

    // Additional methods and getters/setters for custom user details
}

