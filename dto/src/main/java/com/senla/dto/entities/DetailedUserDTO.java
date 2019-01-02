package com.senla.dto.entities;

import com.senla.model.entity.Info;
import com.senla.model.entity.User;

public class DetailedUserDTO extends InfoDTO {
    private String password;
    private String login;
    private int id;

    public DetailedUserDTO() {

    }

    public DetailedUserDTO(User user, Info info) {
        this.password = user.getPassword();
        this.login = user.getLogin();
        setName(info.getName());
        setSurname(info.getSurname());
        setBirthday(info.getBirthday().toString());
        setAbout(info.getAbout());
        setCountry(info.getCountry());
        setId(user.getId());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public User createUserEntity() {
        User user = new User();
        user.setBlocked(Byte.valueOf("0"));
        user.setLogin(getLogin());
        user.setPassword(getPassword());
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
