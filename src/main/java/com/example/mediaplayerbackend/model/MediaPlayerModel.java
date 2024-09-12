package com.example.mediaplayerbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class MediaPlayerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String album;
    private String genre;
    private long duration;
    @Lob
    private byte[] mp3Data;
    @Lob
    private byte[] coverPath;
    private int trackCount;
    private int year;
    private String lyrics;

    public MediaPlayerModel(String title, String artist, String album, String genre, long duration, byte[] mp3Data, int year, String lyrics, byte[] coverPath) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
        this.mp3Data = mp3Data;
        this.year = year;
        this.lyrics = lyrics;
        this.coverPath = coverPath;
    }

}
