package com.sooin.miniproject.models;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    
    private int userId;
    private String userName;
    private String userPassword;
    private String userStatus;
    private Timestamp createDateTime;

}
