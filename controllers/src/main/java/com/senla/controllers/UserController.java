package com.senla.controllers;


import com.senla.dto.entities.*;
import com.senla.model.entity.*;
import com.senla.services.api.*;
import com.senla.utils.DTOUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IInfoService infoService;

    @GetMapping("/user/{id}")
    public InfoDTO getById(@PathVariable("id") Integer id, Model model) {
        Info info = infoService.getByUserId(id);
        DetailedUserDTO infoDTO = new DetailedUserDTO(info.getUser(), info);
        model.addAttribute("info", infoDTO);
        return infoDTO;
    }

    @PostMapping("/searchUser")
    public List<UserDTO> searchUser(@ModelAttribute("user") InfoDTO infoDTO) {
        List<User> users = null;
        try {
            users = userService.getAllUsers(infoDTO.createInfoEntity());
            return DTOUtil.parseUsers(users);
        } catch (ParseException e) {
            return null;
        }

    }
}
