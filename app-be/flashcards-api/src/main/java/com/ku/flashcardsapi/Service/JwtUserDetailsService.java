package com.ku.flashcardsapi.Service;

import com.ku.flashcardsapi.Repo.UserRepository;
import com.ku.flashcardsapi.Security.CustomUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.ku.flashcardsapi.Model.User user = userRepository.findUserByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("");
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
        return new CustomUserDetails(user.getUserName(), user.getPassword(), Long.toString(user.getId()), authorityList);
    }

    public CustomUserDetails createUserDetails(String username, String password, String userId) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
        return new CustomUserDetails(username, password, userId, authorityList);
    }
}
