package io.rugvedmarathe.springbootvalidations.vo;

import lombok.Data;

import java.util.StringJoiner;

@Data
public class LoginVO {

    private String username;
    private String password;

    public String validate() {
        StringJoiner joiner = new StringJoiner(",","[","]");

        if (username.isBlank()){
            joiner.add("Username is blank");
        }
        if (password.isBlank()){
            joiner.add("Password is blank");
        }

        return joiner.toString();
    }
}
