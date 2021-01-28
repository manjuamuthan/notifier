package com.example.notifier.controller;

import com.example.notifier.domain.SkillTestInfo;
import com.example.notifier.service.NotifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotifierController {

    private final NotifierService notifierService;
    @Autowired
    public NotifierController(final NotifierService notifierService) {
        this.notifierService = notifierService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNofification(@RequestBody SkillTestInfo skillTestInfo){
        return notifierService.addNofification(skillTestInfo);
    };

}
