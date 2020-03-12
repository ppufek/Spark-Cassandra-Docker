package com.sparkapp.myFirstSparkApp;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import scala.Tuple2;

@SpringBootApplication
public class MyFirstSparkAppApplication  //implements ApplicationRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(MyFirstSparkAppApplication.class, args);
	}
}
