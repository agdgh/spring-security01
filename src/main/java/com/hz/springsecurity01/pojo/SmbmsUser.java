package com.hz.springsecurity01.pojo;

import lombok.Data;

import javax.management.relation.Role;

@Data
public class SmbmsUser {
    private  String username;
    private  String userpwd;
    private Role role;
}
