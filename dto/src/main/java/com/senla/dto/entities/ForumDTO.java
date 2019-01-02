package com.senla.dto.entities;

import com.senla.model.entity.Forum;
import com.senla.model.entity.User;

public class ForumDTO {
    private int id;
    private String adminLogin;
    private String info;
    private int adminId;

    public ForumDTO() {
    }

    public ForumDTO(Forum forum) {
        this.id = forum.getId();
        this.adminLogin = forum.getAdmin().getLogin();
        this.info = forum.getInfo();
        this.adminId = forum.getAdmin().getId();
    }

    public Forum createForumEntity() {
        Forum forum = new Forum();
        forum.setInfo(this.info);
        User user = new User();
        user.setId(this.adminId);
        forum.setAdmin(user);
        return forum;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String login) {
        this.adminLogin = login;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "ForumDTO{" +
                "id=" + id +
                ", adminLogin='" + adminLogin + '\'' +
                ", info='" + info + '\'' +
                '}';
    }


}
