package com.senla.dto.entities;

import com.senla.model.entity.PrivateMessage;

import java.util.Date;

public class PrivateMessageDTO {
    private int id;
    private String senderLogin;
    private String recipientLogin;
    private int senderId;
    private int recipientId;
    private String text;
    private String date;

    public PrivateMessageDTO() {

    }

    public PrivateMessageDTO(PrivateMessage privateMessage) {
        this.id = privateMessage.getId();
        this.senderLogin = privateMessage.getSender().getLogin();
        this.recipientLogin = privateMessage.getRecipient().getLogin();
        this.senderId = privateMessage.getSender().getId();
        this.recipientId = privateMessage.getRecipient().getId();
        this.text = privateMessage.getText();
        this.date = privateMessage.getDate().toString();
    }

    public PrivateMessage createPrivateMessageEntity(){
        PrivateMessage privateMessage = new PrivateMessage();
        privateMessage.getSender().setId(senderId);
        privateMessage.getRecipient().setId(recipientId);
        privateMessage.setText(text);
        privateMessage.setDate(new Date());
        return privateMessage;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderLogin() {
        return senderLogin;
    }

    public void setSenderLogin(String senderLogin) {
        this.senderLogin = senderLogin;
    }

    public String getRecipientLogin() {
        return recipientLogin;
    }

    public void setRecipientLogin(String recipientLogin) {
        this.recipientLogin = recipientLogin;
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

    @Override
    public String toString() {
        return "PrivateMessageDTO{" +
                "id=" + id +
                ", senderLogin='" + senderLogin + '\'' +
                ", recipientLogin='" + recipientLogin + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }
}
