package com.ttn.service;

import com.ttn.UserRepository;
import com.ttn.config.UserDetailsImpl;
import com.ttn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("*******loading user by username******"+username);
        User user = userRepository.findByUserName(username);
        if (user ==null)
        {
            System.out.println("*********throwing user not fount exception**********");
            throw new UsernameNotFoundException("Invalid Credentials");
        }
        return new UserDetailsImpl(user);
    }
}
