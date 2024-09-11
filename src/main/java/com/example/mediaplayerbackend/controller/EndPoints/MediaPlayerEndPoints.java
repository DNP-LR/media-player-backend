package com.example.mediaplayerbackend.controller.EndPoints;

import com.example.mediaplayerbackend.dto.MediaPlayerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/mediaPlayer")
public interface MediaPlayerEndPoints {

    @GetMapping
    List<MediaPlayerDto> getAllMediaPlayers();
}