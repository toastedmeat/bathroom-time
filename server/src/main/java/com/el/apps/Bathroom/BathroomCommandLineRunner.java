package com.el.apps.Bathroom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.el.apps.Bathroom.models.Bathroom;
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
        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light", "PBR").forEach(name ->
                repository.save(new Bathroom(name))
        );
        repository.findAll().forEach(System.out::println);
    }
}
