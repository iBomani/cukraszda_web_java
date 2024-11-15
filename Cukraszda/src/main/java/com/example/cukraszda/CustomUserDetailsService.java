package com.example.cukraszda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private com.example.cukraszda.userRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }


        return user;
        /*
        Collection<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

         */
    }

}
