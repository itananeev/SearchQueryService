package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.SearchQuery;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/search")
    public void search(@RequestBody SearchQuery query) {
        rabbitTemplate.convertAndSend("search-queue", query);
    }
}
