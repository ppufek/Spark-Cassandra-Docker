package com.sparkapp.myFirstSparkApp.models;

import java.util.UUID;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Table("bookstore")
public class BookStoreEntity
{
    public BookStoreEntity(){
        this.id = UUIDs.timeBased();
    }

    @PrimaryKeyColumn(name = "id", type= PrimaryKeyType.PARTITIONED)
    private UUID id;

    @Column(value = "title")
    private String title;

    @Column(value = "author")
    private String author;
}
