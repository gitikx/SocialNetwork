package com.senla.dto.entities;

import com.senla.model.entity.Info;
import com.senla.model.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InfoDTO {
    private String name;
    private String surname;
    private String country;
    private String birthday;
    private String about;

    public InfoDTO(){

    }

    public InfoDTO(Info info){
        this.name = info.getName();
        this.surname = info.getSurname();
        this.country = info.getCountry();
        this.birthday = info.getBirthday().toString();
        this.about = info.getAbout();
    }

    public Info createInfoEntity() throws ParseException {
        Info info = new Info();
        info.setName(this.name);
        info.setSurname(this.surname);
        info.setAbout(this.about);
        info.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse(this.birthday));
        info.setCountry(this.country);
        User user = new User();
        info.setUser(user);
        return info;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "InfoDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", birthday=" + birthday +
                ", about='" + about + '\'' +
                '}';
    }
}
