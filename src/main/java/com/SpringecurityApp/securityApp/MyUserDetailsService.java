package com.SpringecurityApp.securityApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrinciple(user);
    }

    /*
    The method returns the object of type UserDetails, but UserDetais is an interface . so we can't make an object of it. In order to return the object of
    type UserDetails, we make a class UserPrinciple which implements UserDetails,a nd implement the methods. These methods will set the loggend in user credentials and
    manage authorisation. It will then return the object of UserPrinciple with state values of current user.
     */
}
