package com.senla.controllers;

import com.senla.dto.entities.UserDTO;
import com.senla.model.entity.Friend;
import com.senla.services.api.IFriendsService;
import com.senla.utils.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/")
public class FriendController {
    @Autowired
    IFriendsService friendsService;

    @GetMapping("/friends")
    public List<UserDTO> getFriends(@SessionAttribute(value = "id") Integer id) {
        List<UserDTO> list = DTOUtil.parseUsers(friendsService.getByUserId(id));
        return list;
    }

    @GetMapping("/requests")
    public List<UserDTO> getRequests(@SessionAttribute(value = "id") Integer id) {
        List<UserDTO> requests = DTOUtil.parseUsers(friendsService.getRequestsById(id));
        return requests;
    }

    @GetMapping("/friends/delete/{id}")
    public Integer deleteFriend(@PathVariable("id") Integer friendId, @SessionAttribute(value = "id") int userId) {
        Friend friend = new Friend(friendId, userId);
        friendsService.delete(friend);
        return HttpServletResponse.SC_ACCEPTED;
    }

    @GetMapping("/friends/add/{id}")
    public Integer addFriend(@PathVariable("id") Integer friendId, @SessionAttribute(value = "id") int userId) {
        Friend friend = new Friend(friendId, userId);
        friendsService.addFriend(friend);
        return HttpServletResponse.SC_CREATED;
    }

    @GetMapping("/friends/accept/{id}")
    public Integer acceptFriend(@PathVariable("id") Integer friendId, @SessionAttribute(value = "id") int userId) {
        Friend friend = new Friend(userId, friendId);
        friendsService.acceptFriend(friend);
        return HttpServletResponse.SC_ACCEPTED;
    }
}
