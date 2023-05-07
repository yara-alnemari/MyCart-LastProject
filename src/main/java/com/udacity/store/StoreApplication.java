package com.udacity.store;

import com.udacity.store.model.Product;
import com.udacity.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.nio.file.Files;


@SpringBootApplication
public class StoreApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @Autowired
     ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO: Populate the database with products
        productRepository.save(new Product("Mug", "Large Latte Mug", "https://m.media-amazon.com/images/I/61vbV+u+89L._AC_SX679_.jpg", 15));
        productRepository.save(new Product("Temperature Mug", "Temperature Control Smart Mug with Lid", "https://m.media-amazon.com/images/I/61DuGB2BhqL._AC_SX679_.jpg", 60));
        System.out.println("Products Saved");
    }
}
