package com.sparkapp.myFirstSparkApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparkapp.myFirstSparkApp.services.BookStoreService;

@RestController
@RequestMapping(path="/books")
public class Controller
{
    BookStoreService bookStoreService;

    public Controller(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @RequestMapping("/")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookStoreService.getAllBooks(), HttpStatus.OK);
    }

}
