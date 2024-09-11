package com.example.mediaplayerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediaPlayerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaPlayerBackendApplication.class, args);
    }

//    @Bean
//    CommandLineRunner initDatabase(MediaPlayerRepository repository) {
//        return args -> {
//            List<MediaPlayerModel> songs = new ArrayList<>();
//            songs.add(new MediaPlayerModel("Bohemian Rhapsody", "Queen", "A Night at the Opera", "Rock", 355, 1, 11, 1975, "A classic rock anthem", "path/to/cover.jpg"));
//            songs.add(new MediaPlayerModel("Imagine", "John Lennon", "Imagine", "Pop", 290, 1, 1, 1971, "A message of peace and hope", "path/to/cover.jpg"));
//            songs.add(new MediaPlayerModel("Like a Rolling Stone", "Bob Dylan", "Highway 61 Revisited", "Folk", 438, 1, 11, 1965, "A powerful and influential song", "path/to/cover.jpg"));
//            repository.saveAll(songs);
//        };
//    }
}
