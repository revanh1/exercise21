package org.abbtech.practice.lesson23_orm.service.impl;

import org.abbtech.practice.lesson23_orm.dto.CustomUserDetailDTO;
import org.abbtech.practice.lesson23_orm.model.UserInfo;
import org.abbtech.practice.lesson23_orm.repository.UserRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userInfo = userRepository.findUserInfoByUsernameIgnoreCase(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(401)));
        return new CustomUserDetailDTO((UserInfo) userInfo);
    }
}
