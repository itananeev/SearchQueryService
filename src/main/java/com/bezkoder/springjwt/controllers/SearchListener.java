package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Book;
import com.bezkoder.springjwt.models.SearchQuery;
import com.bezkoder.springjwt.services.SearchService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchListener {
    @Autowired
    private SearchService searchService;

    @RabbitListener(queues = "search-queue")
    public void handleSearch(SearchQuery query) {
        List<Book> books = searchService.searchByTitle(query.getTitle());
        // do something with the search results (e.g. send them back to the caller via a response queue)
    }
}

