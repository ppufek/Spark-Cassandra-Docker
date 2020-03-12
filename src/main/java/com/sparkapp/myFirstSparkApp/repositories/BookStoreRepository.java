package com.sparkapp.myFirstSparkApp.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.sparkapp.myFirstSparkApp.models.BookStoreEntity;

@Repository
public interface BookStoreRepository extends CassandraRepository<BookStoreEntity, UUID>
{
}
