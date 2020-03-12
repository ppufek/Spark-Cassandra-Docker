package com.sparkapp.myFirstSparkApp.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.sparkapp.myFirstSparkApp.models.BookStoreEntity;
import com.sparkapp.myFirstSparkApp.models.BookStoreInput;
import com.sparkapp.myFirstSparkApp.models.BookStoreOutput;

public class ModelConverterUtil {

    public static List<BookStoreOutput> convertEntityListToOutputList(Iterable<BookStoreEntity> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map( entity -> convertEntityToOutput(entity))
                .collect(Collectors.toList());
    }

    public static BookStoreOutput convertEntityToOutput(BookStoreEntity entity) {
        return BookStoreOutput.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .build();
    }


    public static BookStoreEntity convertInputToEntity(BookStoreInput input) {
        return BookStoreEntity.builder()
                .id(input.getId())
                .title(input.getTitle())
                .author(input.getAuthor())
                .build();
    }
}
