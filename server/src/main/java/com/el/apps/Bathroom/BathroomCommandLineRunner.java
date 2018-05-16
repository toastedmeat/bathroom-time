package com.el.apps.Bathroom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.el.apps.Bathroom.models.Bathroom;
import com.el.apps.Bathroom.models.User;
import com.el.apps.Bathroom.repositories.BathroomRepository;

import java.util.stream.Stream;

@Component
public class BathroomCommandLineRunner implements CommandLineRunner {

    private final BathroomRepository repository;

    public BathroomCommandLineRunner(BathroomRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
    	System.out.println("Running Bathroom Init");
    	repository.deleteAll();
    	repository.save(new Bathroom("Alice"));
    }
}
