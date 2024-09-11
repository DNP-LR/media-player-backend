package com.example.mediaplayerbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediaPlayerDto {
    private Long id;
    @NotNull
    private String title;
    private String artist;
    private String album;
    private String genre;
    private long duration;
    private int trackNumber;
    private int trackCount;
    private int year;
    private String comment;
    private String coverPath;
}
