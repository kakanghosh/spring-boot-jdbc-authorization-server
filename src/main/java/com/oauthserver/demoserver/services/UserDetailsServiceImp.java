package com.oauthserver.demoserver.services;

import com.oauthserver.demoserver.models.User;
import com.oauthserver.demoserver.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImp.class);
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> userOptional = userRepository.findByUsername(username);
       return userOptional.orElseThrow(()-> new UsernameNotFoundException("Username or Password wrong"));
    }
}
