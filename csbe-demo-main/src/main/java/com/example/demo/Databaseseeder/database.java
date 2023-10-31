package com.example.demo.Databaseseeder;

import com.example.demo.Category.Category;
import com.example.demo.Category.CategoryRepository;
import com.example.demo.Product.Product;
import com.example.demo.Product.ProductRepository;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Database seeder class responsible for initializing data in the database tables.
 */

@Component
public class database implements CommandLineRunner {

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    private Long id;

    /**
     * Seeds the database with initial data for users, categories, and products.
     */

    public void seedDatabase() {
        seedUsers();
        seedCategories();
        seedProducts();
    }

    /**
     * Seeds the User table with initial set of users.
     * Adds users to the database if there are fewer than 5 users.
     */

    private void seedUsers() {
        // Checking if there are fewer than 5 users
        if (userRepository.count() < 5) {
            // Creating and saving admin user
            User admin = new User();
            admin.setName("admin");
            admin.setPassword(bCryptPasswordEncoder.encode("admin123"));
            admin.setAdmin(true);
            userRepository.save(admin);

            // Creating and saving test user 1
            User test1 = new User();
            test1.setName("test1");
            test1.setPassword(bCryptPasswordEncoder.encode("test047"));
            test1.setAdmin(false);
            userRepository.save(test1);

            // Creating and saving test user 2
            User test2 = new User();
            test2.setName("test2");
            test2.setPassword(bCryptPasswordEncoder.encode("test442"));
            test2.setAdmin(false);
            userRepository.save(test2);

            // Creating and saving test user 3
            User test3 = new User();
            test3.setName("test3");
            test3.setPassword(bCryptPasswordEncoder.encode("test787"));
            test3.setAdmin(false);
            userRepository.save(test3);

            // Creating and saving test user 4
            User test4 = new User();
            test4.setName("test4");
            test4.setPassword(bCryptPasswordEncoder.encode("test007"));
            test4.setAdmin(false);
            userRepository.save(test4);
        }
    }

    /**
     * Seeds the Category table with initial categories.
     */

    private void seedCategories() {
        // Checking if there are fewer than 5 categories
        if (categoryRepository.count() < 5) {
            // Creating and saving Electronics category
            Category electronics = new Category();
            electronics.setName("Electronics");
            categoryRepository.save(electronics);

            // Creating and saving Clothing category
            Category clothing = new Category();
            clothing.setName("Clothing");
            categoryRepository.save(clothing);
        }
    }
    private void seedProducts() {

        // You should have access to your product repository.
        // If not, you need to inject it using @Autowired.
        // I assume there is a productRepository.count() as in the previous code.

        if (productRepository.count() < 5) {
            Product display = new Product();
            display.setName("Display");
            display.setDescription("High quality display with great resolution");
            display.setPrice(9999.99f);
            display.Floor("DSPY-12345");
            display.setImagePath("https://www.samsung.com/ch/tvs/qled-tv/qn900c-85-inch-neo-qled-8k-smart-tv-qe85qn900ctxzu/?cid=ch_pd_ppc_google_tvs_ongoing_tvs_pla_shopping_none_su2022&gad=1&gclid=Cj0KCQjwqP2pBhDMARIsAJQ0Czq2Rsnbm8wMu0WIDu3aROoFLtND5YrR03I5mlDSWrnk_o4D9Z8Vf6gaApgBEALw_wcB&gclsrc=aw.ds");

            display.setCategory(categoryRepository.findAllByName("Electronics"));
            productRepository.save(display);

            Product sweater = new Product();
            sweater.setName("sweater");
            sweater.setDescription("Cotton shirt, red color");
            sweater.setPrice(29.99f);
            sweater.Floor("SWW-12345");
            sweater.setCategory(categoryRepository.findAllByName("Clothing"));
            productRepository.save(sweater);

            // You can add more products by duplicating and customizing the above code.

        }
    }
    @Override
    public void run(String... args) throws Exception {
    }
}

