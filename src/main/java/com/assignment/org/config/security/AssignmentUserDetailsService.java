package com.assignment.org.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assignment.org.persistence.model.User;
import com.assignment.org.persistence.repository.UserRepository;


@Service
public class AssignmentUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findFirstByEmailId(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AssignmentUserPrincipal(user);
    }

}
