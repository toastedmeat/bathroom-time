package com.el.apps.Bathroom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.el.apps.Bathroom.models.User;
import com.el.apps.Bathroom.repositories.UserRepository;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
    
    
    private final UserRepository users;

    public UserCommandLineRunner(UserRepository users) {
        this.users = users;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Running User Init");
        users.deleteAll();
        
        users.save(new User("eloo", "Eric", null, "Loo", "eloo12@gmail.com"));
        users.save(new User("jzeng", "Jessica", null, "Zeng", "jessicazengg@gmail.com"));
        users.save(new User("hqu", "Haibin", null, "qu", "haibinqu@hotmail.com"));
        users.save(new User("bqu", "Bob", null, "qu", "bobqu@hotmail.com"));
        users.save(new User("haqu", "Harris", null, "qu", "harrisqu@hotmail.com"));
        
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (User user : users.findAll()) {
            System.out.println(user);
        }
        System.out.println();

        // fetch an individual user
        System.out.println("User found with findByFirstName('Jessica'):");
        System.out.println("--------------------------------");
        System.out.println(users.findByFirstNameAllIgnoreCase("Jessica"));
        
        // fetch an individual user not found
        System.out.println("User found with findByFirstName('Jessicah'):");
        System.out.println("--------------------------------");
        System.out.println(users.findByUsernameAllIgnoreCase("Jessicah"));

        // find multiple users with last name qu
        System.out.println("Users found with findByLastName('Qu'):");
        System.out.println("--------------------------------");
        for (User user : users.findByLastNameAllIgnoreCase("qu")) {
            System.out.println(user);
        }
    }
}
