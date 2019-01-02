package com.senla.controllers;

import com.senla.dto.entities.PrivateMessageDTO;
import com.senla.dto.entities.UserDTO;
import com.senla.model.dao.api.IPrivateMessageDao;
import com.senla.model.entity.Friend;
import com.senla.model.entity.PrivateMessage;
import com.senla.model.entity.User;
import com.senla.services.api.IPrivateMessageService;
import com.senla.utils.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    IPrivateMessageService privateMessageService;

    @GetMapping("")
    public List<UserDTO> getMessages(@SessionAttribute(value = "id") int id, Model model) {
        Set<User> users = privateMessageService.getDialogsByUserId(id);
        List<UserDTO> usersDTO = DTOUtil.parseUsers(users);
        model.addAttribute("users", usersDTO);
        return usersDTO;
    }

    @GetMapping("/{id}")
    public List<PrivateMessageDTO> getDialog(@SessionAttribute(value = "id") int userId, @PathVariable("id") int friendId, Model model) {
        Friend friend = new Friend();
        friend.getFriendOne().setId(userId);
        friend.getFriendTwo().setId(friendId);
        List<PrivateMessageDTO> privateMessageDTOList = DTOUtil.parsePrivateMessages(privateMessageService.getDialog(friend));
        return privateMessageDTOList;
    }

    @PostMapping("/{id}")
    public Integer sendMessage(@ModelAttribute("text") String text, @SessionAttribute(value = "id") int userId, @PathVariable("id") int friendId) {
        PrivateMessage privateMessage = new PrivateMessage();
        privateMessage.getRecipient().setId(friendId);
        privateMessage.getSender().setId(userId);
        privateMessage.setText(text);
        privateMessage.setDate(new Date());
        privateMessageService.create(privateMessage);
        return HttpServletResponse.SC_CREATED;
    }
}
