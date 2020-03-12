package com.sparkapp.myFirstSparkApp.services;

import java.util.List;

import com.sparkapp.myFirstSparkApp.models.BookStoreEntity;
import com.sparkapp.myFirstSparkApp.models.BookStoreOutput;

public interface BookStoreService
{
    List<BookStoreOutput> getAllBooks();
    BookStoreOutput saveBook(BookStoreEntity b);
}
