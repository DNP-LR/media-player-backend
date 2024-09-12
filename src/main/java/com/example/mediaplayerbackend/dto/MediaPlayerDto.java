package com.example.mediaplayerbackend.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediaPlayerDto {
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

}
