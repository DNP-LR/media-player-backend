package com.example.mediaplayerbackend;

import com.example.mediaplayerbackend.model.MediaPlayerModel;
import com.example.mediaplayerbackend.repo.MediaPlayerRepository;
import com.example.mediaplayerbackend.utils.ImageUtils;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

@SpringBootApplication
public class MediaPlayerBackendApplication {

    @Resource
    private MediaPlayerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MediaPlayerBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            List<MediaPlayerModel> songs = new ArrayList<>();
            songs.add(new MediaPlayerModel("Bohemian Rhapsody", "Queen", "A Night at the Opera", "Rock", 355,
                    loadMp3Data("src/main/resources/StockTuneStarryNightLullaby_1726081192.mp3"), 1975,
                    "A classic rock anthem", compressAndLoadImage("src/main/resources/figma.png")));

            for (MediaPlayerModel song : songs) {
                try {
                    byte[] decompressedImage = ImageUtils.decompressImage(song.getCoverPath());
                    song.setCoverPath(decompressedImage); // Setting decompressed image

                    song.setMp3Data(loadMp3Data(Arrays.toString(song.getMp3Data())));
                } catch (IOException | DataFormatException e) {
                    System.err.println("Error processing media: " + e.getMessage());
                }
            }
            repository.saveAll(songs);
        };
    }

    private byte[] compressAndLoadImage(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        FileInputStream inputStream = new FileInputStream(imageFile);
        byte[] imageData = new byte[(int) imageFile.length()];
        inputStream.read(imageData);
        inputStream.close();

        return ImageUtils.compressImage(imageData);
    }

    private byte[] loadMp3Data(String mp3Path) throws IOException {
        File mp3File = new File(mp3Path);
        FileInputStream inputStream = new FileInputStream(mp3File);
        byte[] mp3Data = new byte[(int) mp3File.length()];
        inputStream.read(mp3Data);
        inputStream.close();
        return mp3Data;
    }
}
