package com.senla.dto.entities;

import com.senla.model.entity.News;
import com.senla.model.entity.User;

public class NewsDTO {
    private int id;
    private String userLogin;
    private String text;
    private int userId;

    public NewsDTO() {

    }

    public NewsDTO(News news) {
        this.id = news.getId();
        this.userLogin = news.getUser().getLogin();
        this.text = news.getText();
        this.userId = news.getUser().getId();
    }

    public News createNewsEntity() {
        News news = new News();
        news.setText(this.text);
        User user = new User();
        user.setId(this.userId);
        news.setUser(user);
        return news;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "id=" + id +
                ", userLogin='" + userLogin + '\'' +
                ", text='" + text + '\'' +
                '}';
    }



}
