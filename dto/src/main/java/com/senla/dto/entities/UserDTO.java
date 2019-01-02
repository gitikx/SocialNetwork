package com.senla.dto.entities;


import com.senla.model.entity.User;

public class UserDTO{
    private int id;
    private String login;
    private String password;

    public UserDTO(){

    }

    public UserDTO(User user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User createUserEntity(){
        User user = new User();
        user.setLogin(this.login);
        user.setPassword(this.password);
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
