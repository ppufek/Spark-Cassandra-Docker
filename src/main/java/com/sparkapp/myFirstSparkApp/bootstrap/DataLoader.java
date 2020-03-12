package com.sparkapp.myFirstSparkApp.bootstrap;


import com.sparkapp.myFirstSparkApp.models.BookStoreEntity;
import com.sparkapp.myFirstSparkApp.services.BookStoreService;
import lombok.experimental.var;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Arrays.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookStoreService bookStoreService;
    private static final Pattern SPACE = Pattern.compile(" ");


    public DataLoader(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = bookStoreService.getAllBooks().size();
        System.out.println("Book count: " + count);

        BookStoreEntity b = new BookStoreEntity();
        b.setTitle("New Book");
        b.setAuthor("Unknown");

        bookStoreService.saveBook(b);

        int countAfterInsertion = bookStoreService.getAllBooks().size();
        System.out.println("Book count after insertion: " + countAfterInsertion);


        SparkConf sparkConf = new SparkConf().setAppName("JavaWordCount").setMaster("local[2]");
        JavaSparkContext ctx = new JavaSparkContext(sparkConf);

        JavaRDD<String> lines = ctx.textFile("example.txt", 1);
        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());
        JavaPairRDD<String, Integer> ones = words.mapToPair(word -> new Tuple2<>(word, 1));
        JavaPairRDD<String, Integer> counts = ones.reduceByKey((Integer i1, Integer i2) -> i1 + i2);

        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<?, ?> tuple : output) {
            System.out.println(tuple._1() + " : " + tuple._2());
        }
        ctx.stop();
    }
}


