package com.sparkapp.myFirstSparkApp.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookStoreInput
{
    private UUID id;
    private String title;
    private String author;
}
