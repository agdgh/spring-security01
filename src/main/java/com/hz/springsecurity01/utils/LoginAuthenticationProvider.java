package com.hz.springsecurity01.utils;

import com.hz.springsecurity01.pojo.SmbmsUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class LoginAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
          String userName = (String) authentication.getPrincipal();  //获取用户名
          String userpwd= (String) authentication.getCredentials();// 获取用户密码
        SmbmsUser smbmsUser = new SmbmsUser();
        smbmsUser.setUsername(userName);
        smbmsUser.setUserpwd(userpwd);
        if (smbmsUser!=null){
            // 将角色字符串转换为集合
            Collection<GrantedAuthority> authorities =
                    AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
            return new UsernamePasswordAuthenticationToken(smbmsUser,smbmsUser.getUserpwd(),authorities);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
