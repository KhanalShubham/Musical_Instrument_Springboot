package com.example.musical_instrument.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPojo {

    private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_email;
    private String user_contact;
    private String user_role;

}
