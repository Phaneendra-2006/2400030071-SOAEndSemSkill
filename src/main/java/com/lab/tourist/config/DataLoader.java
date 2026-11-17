package com.lab.tourist.config;

import com.lab.tourist.entity.Tourist;
import com.lab.tourist.repository.TouristRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner loadSampleTourists(TouristRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Tourist("Ravi Kumar", "9876543210",
                        "ravi@example.com", "Hyderabad", "Hotel Green Park"));
                repository.save(new Tourist("Sita Devi", "9123456780",
                        "sita@example.com", "Vijayawada", "Hotel Swarna Palace"));
            }
        };
    }
}
