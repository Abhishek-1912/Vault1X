package com.example.Vault1X.dto;

public class UsersUpdateDto {
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;

    public String getusername() {
        return userName;
    }

    public void setusername(String userName) {
        this.userName = userName;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }
}
