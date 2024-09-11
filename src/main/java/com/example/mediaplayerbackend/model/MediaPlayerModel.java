package com.example.mediaplayerbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MediaPlayerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String album;
    private String genre;
    private long duration;
    private int trackNumber;
    private int trackCount;
    private int year;
    private String lyrics;
    private String coverPath;

    public MediaPlayerModel(String title, String artist, String album, String genre, long duration, int trackNumber, int trackCount, int year, String lyrics, String coverPath) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
        this.trackNumber = trackNumber;
        this.trackCount = trackCount;
        this.year = year;
        this.lyrics = lyrics;
        this.coverPath = coverPath;
    }
}
