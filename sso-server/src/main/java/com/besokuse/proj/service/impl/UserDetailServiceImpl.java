package com.besokuse.proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author: besokuse
 * @since: 2020/9/14 19:45
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 为了方便测试登录账号密码在此写死 可以重数据库获取
     * @param s 账号
     * @return  账号 密码 权限列表【在此只给了admin权限】
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("admin",passwordEncoder.encode("123"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
