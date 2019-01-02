package com.senla.dto.entities;


import com.senla.model.entity.Forum;
import com.senla.model.entity.PublicMessage;
import com.senla.model.entity.User;

import java.util.Date;

public class PublicMessageDTO {
    private int id;
    private String text;
    private String date;
    private String senderLogin;
    private int senderId;
    private int forumId;

    public PublicMessageDTO() {

    }

    public PublicMessageDTO(PublicMessage publicMessage) {
        this.text = publicMessage.getText();
        this.date = publicMessage.getDate().toString();
        this.senderLogin = publicMessage.getSender().getLogin();
        this.senderId = publicMessage.getSender().getId();
    }

    public PublicMessage createPublicMessageEntity() {
        PublicMessage publicMessage = new PublicMessage();
        publicMessage.setText(this.text);
        publicMessage.setDate(new Date());
        User user = new User();
        user.setId(this.senderId);
        publicMessage.setSender(user);
        Forum forum = new Forum();
        forum.setId(this.forumId);
        publicMessage.setForum(forum);
        return publicMessage;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSenderLogin() {
        return senderLogin;
    }

    public void setSenderLogin(String senderLogin) {
        this.senderLogin = senderLogin;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    @Override
    public String toString() {
        return "PublicMessageDTO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", senderLogin='" + senderLogin + '\'' +
                '}';
    }


    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }


}
