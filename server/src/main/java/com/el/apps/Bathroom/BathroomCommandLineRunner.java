package com.el.apps.Bathroom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.el.apps.Bathroom.models.Bathroom;
import com.el.apps.Bathroom.repositories.BathroomRepository;

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
        repository.save(new Bathroom("DC", 38.901625, -77.017305, 0));
    }
}
