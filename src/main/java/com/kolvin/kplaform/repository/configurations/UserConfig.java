package com.kolvin.kplaform.repository.configurations;

import com.kolvin.kplaform.models.TelcoUser;
import com.kolvin.kplaform.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

  @Bean
  CommandLineRunner commandLineRunner(UserRepository userRepository) {
    return args -> {
      userRepository.saveAll(
              List.of(
                      new TelcoUser(
                              "tel:+94712933664",
                              1,
                              "MOBITEL"
                      ),
                      new TelcoUser(
                              "tel:+94769198813",
                              2,
                              "DIALOG"
                      ),
                      new TelcoUser(
                              "tel:+94718033449",
                              1,
                              "MOBITEL"
                      )
              )
      );
    };
  }
}
