package com.senla.controllers;

import com.senla.dto.entities.UserDTO;
import com.senla.services.api.IAuthService;
import com.senla.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    IAuthService authService;

    @GetMapping("")
    public String loginPage(){
        return "login page";
    }

    @PostMapping("")
    public Integer login(@ModelAttribute("user") UserDTO userDTO, HttpServletRequest httpServletRequest) {
        Integer id = authService.checkCredentials(userDTO.createUserEntity());
        if (id != null) {
            httpServletRequest.getSession().setAttribute("authToken", JwtUtil.getToken(userDTO.getLogin()));
            httpServletRequest.getSession().setAttribute("id", id);
            return id;
        } else {
            return 0;
        }
    }
}
