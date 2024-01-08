package com.beecode.security.service;

import com.beecode.model.security.User;
import com.beecode.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.beecode.security.JwtUserFactory;

@Service("jwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byLastname = userRepository.findByLastname("admin");
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
