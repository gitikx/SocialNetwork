package com.senla.controllers;

import com.senla.dto.entities.ForumDTO;
import com.senla.dto.entities.PublicMessageDTO;
import com.senla.services.api.IForumService;
import com.senla.services.api.IPublicMessageService;
import com.senla.utils.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/forums")
public class ForumController {

    @Autowired
    IForumService forumService;
    @Autowired
    IPublicMessageService publicMessageService;

    @GetMapping("")
    public List<ForumDTO> getForums(@SessionAttribute(value = "id") Integer id) {
        List<ForumDTO> forumDTOList = DTOUtil.parseForums(forumService.getByUserId(id));
        return forumDTOList;
    }

    @PostMapping("")
    public Integer addForum(@ModelAttribute("forumDTO") ForumDTO forumDTO, @SessionAttribute(value = "id") Integer id) {
        forumDTO.setAdminId(id);
        forumService.addForum(forumDTO.createForumEntity());
        return HttpServletResponse.SC_CREATED;
    }

    @GetMapping("/{id}")
    public List<PublicMessageDTO> getForumById(@PathVariable("id") int id, Model model) {
        List<PublicMessageDTO> publicMessageDTOS = DTOUtil.parsePublicMessages(publicMessageService.getByForumId(id));
        ForumDTO forumDTO = new ForumDTO(forumService.getById(id));
        model.addAttribute("messagesDTO", publicMessageDTOS);
        return publicMessageDTOS;
    }

    @PostMapping("/{id}")
    public Integer addPublicMessage(@ModelAttribute("text") PublicMessageDTO publicMessageDTO, @PathVariable("id") int forumId, @SessionAttribute(value = "id") Integer userId) {
        publicMessageDTO.setSenderId(userId);
        publicMessageDTO.setForumId(forumId);
        forumService.addMessage(publicMessageDTO.createPublicMessageEntity());
        return HttpServletResponse.SC_CREATED;
    }
}
