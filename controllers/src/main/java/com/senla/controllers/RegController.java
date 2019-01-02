package com.senla.controllers;

import com.senla.dto.entities.DetailedUserDTO;
import com.senla.services.api.IUserService;
import com.senla.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/register")
public class RegController {

    @Autowired
    IUserService userService;

    @GetMapping("")
    public String register() {
        return "registerPage";
    }


    @PostMapping("")
    public Integer register(@ModelAttribute("regDTO") DetailedUserDTO detailedUserDTO, HttpServletRequest httpServletRequest) {
        try {
            int id = userService.create(detailedUserDTO.createUserEntity(), detailedUserDTO.createInfoEntity());
            httpServletRequest.getSession().setAttribute("authToken", JwtUtil.getToken(detailedUserDTO.getLogin()));
            httpServletRequest.getSession().setAttribute("id", id);
            return id;
        } catch (Exception ex) {
            return HttpServletResponse.SC_BAD_REQUEST;
        }
    }
}
