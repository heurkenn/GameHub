package fr.gamehub.gamehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import fr.gamehub.gamehub.service.CommunityService;

@Controller

public class CommunityListController {

    @Autowired
    private CommunityService communityService;

    @GetMapping(value = "/communityList")
    public String goCommunityList(Model model){
    model.addAttribute("allComunities", communityService.getCommunity());
    return "communityList";
    }

}