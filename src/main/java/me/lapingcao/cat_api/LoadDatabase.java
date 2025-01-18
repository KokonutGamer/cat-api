package me.lapingcao.cat_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CatRepository repository) {
        String logText = "Preloading {}";
        return args -> {
            log.info(logText, repository.save(new Cat(
                "Timmy",
                Breed.BENGAL,
                20,
                10
            )));
            log.info(logText, repository.save(new Cat(
                "Martha",
                Breed.MAINE_COON,
                18,
                9
            )));
            log.info(logText, repository.save(new Cat(
                "Jacky",
                Breed.SIAMESE,
                8,
                7
            )));
        };
    }
}