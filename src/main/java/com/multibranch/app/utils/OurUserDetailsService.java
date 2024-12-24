package com.multibranch.app.utils;


import com.multibranch.app.entities.request.user.OurUsers;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.repositories.user.IUserRepository;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class OurUserDetailsService implements UserDetailsService {


    private IUserRepository userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Map<String, Object>> result = null;
        try {
            result = userService.findByUserName(username);
        } catch (DataSourceException e) {
            throw new RuntimeException(e);
        }
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        Map<String, Object> userRow = result.get(0); // Tomamos el primer resultado

        // Convertimos los datos del resultado a la entidad OurUsers
        OurUsers user = new OurUsers();
        user.setId((Integer) userRow.get("id"));
        user.setEmail((String) userRow.get("email"));
        user.setName((String) userRow.get("name"));
        user.setPassword((String) userRow.get("password"));
//        user.setCity((String) userRow.get("city"));
        user.setRole((String) userRow.get("role"));
        return user;
    }
}
