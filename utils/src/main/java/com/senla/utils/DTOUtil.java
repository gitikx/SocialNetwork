package com.senla.utils;

import com.senla.dto.entities.*;
import com.senla.model.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DTOUtil {
    public static List<NewsDTO> parseNews(List<News> feed) {
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News news : feed) {
            newsDTOList.add(new NewsDTO(news));
        }
        return newsDTOList;
    }

    public static List<ForumDTO> parseForums(List<Forum> forums) {
        List<ForumDTO> forumDTOList = new ArrayList<>();
        for (Forum forum : forums) {
            forumDTOList.add(new ForumDTO(forum));
        }
        return forumDTOList;
    }

    public static List<PublicMessageDTO> parsePublicMessages(List<PublicMessage> publicMessages) {
        List<PublicMessageDTO> publicMessageDTOList = new ArrayList<>();
        for (PublicMessage publicMessage : publicMessages) {
            publicMessageDTOList.add(new PublicMessageDTO(publicMessage));
        }
        return publicMessageDTOList;
    }

    public static List<UserDTO> parseUsers(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }

    public static List<UserDTO> parseUsers(Set<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            userDTOList.add(new UserDTO(user));
        }
        return userDTOList;
    }

    public static List<PrivateMessageDTO> parsePrivateMessages(List<PrivateMessage> privateMessages) {
        List<PrivateMessageDTO> privateMessageDTOList = new ArrayList<>();
        for (PrivateMessage privateMessage : privateMessages) {
            privateMessageDTOList.add(new PrivateMessageDTO(privateMessage));
        }
        return privateMessageDTOList;
    }
}
