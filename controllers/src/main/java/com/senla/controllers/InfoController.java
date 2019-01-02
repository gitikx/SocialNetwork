package com.senla.controllers;

import com.senla.dto.entities.InfoDTO;
import com.senla.dto.entities.NewsDTO;
import com.senla.model.entity.Info;
import com.senla.model.entity.News;
import com.senla.services.api.IInfoService;
import com.senla.services.api.INewsService;
import com.senla.utils.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/")
public class InfoController {

    @Autowired
    INewsService newsService;
    @Autowired
    IInfoService infoService;

    @GetMapping("/myPage")
    public List<NewsDTO> myPage(@SessionAttribute(value = "id") Integer id) {
        List<News> news = newsService.getByUserId(id);
        return DTOUtil.parseNews(news);
    }

    @PostMapping("/myPage")
    public Integer addUser(@SessionAttribute(value = "id") Integer id, @ModelAttribute("newsDTO") NewsDTO newsDTO) {
        newsDTO.setUserId(id);
        newsService.addNews(newsDTO.createNewsEntity());
        return HttpServletResponse.SC_CREATED;
    }

    @PostMapping("/aboutMe")
    public Integer updateInfo(@SessionAttribute(value = "id") Integer id, @ModelAttribute(value = "info") InfoDTO infoDTO)  {
        Info info = null;
        try {
            info = infoDTO.createInfoEntity();
            info.getUser().setId(id);
            infoService.update(info);
            return HttpServletResponse.SC_CREATED;
        } catch (ParseException e) {
            return HttpServletResponse.SC_BAD_REQUEST;
        }

    }

    @GetMapping("/aboutMe")
    public InfoDTO about(@SessionAttribute(value = "id") Integer id, Model model) {
        Info info = infoService.getByUserId(id);
        InfoDTO infoDTO = new InfoDTO(info);
        return infoDTO;
    }
}
