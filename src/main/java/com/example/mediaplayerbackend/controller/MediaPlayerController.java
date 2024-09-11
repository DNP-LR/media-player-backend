package com.example.mediaplayerbackend.controller;

import com.example.mediaplayerbackend.controller.EndPoints.MediaPlayerEndPoints;
import com.example.mediaplayerbackend.dto.MediaPlayerDto;
import com.example.mediaplayerbackend.service.Implementation.MediaPlayerRepoImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MediaPlayerController implements MediaPlayerEndPoints {
    private final MediaPlayerRepoImplementation mediaPlayerRepoImplementation;

    @Override
    public List<MediaPlayerDto> getAllMediaPlayers() {
        return mediaPlayerRepoImplementation.listAllMediaPlayers();
    }
}