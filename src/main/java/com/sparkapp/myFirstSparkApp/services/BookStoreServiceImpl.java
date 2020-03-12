package com.sparkapp.myFirstSparkApp.services;

import java.util.List;

import com.sparkapp.myFirstSparkApp.models.BookStoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkapp.myFirstSparkApp.models.BookStoreOutput;
import com.sparkapp.myFirstSparkApp.repositories.BookStoreRepository;

@Service
public class BookStoreServiceImpl implements BookStoreService
{
    private BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository)
    {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStoreOutput> getAllBooks()
    {
        return ModelConverterUtil.convertEntityListToOutputList(bookStoreRepository.findAll());
    }

    @Override
    public BookStoreOutput saveBook(BookStoreEntity b) {
        return ModelConverterUtil.convertEntityToOutput(bookStoreRepository.save(b));
    }

}
