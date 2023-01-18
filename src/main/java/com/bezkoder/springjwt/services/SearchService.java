package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Book;
import com.bezkoder.springjwt.repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private BooksRepo bookRepository;

    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}

