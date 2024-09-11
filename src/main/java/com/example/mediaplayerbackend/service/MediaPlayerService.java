package com.example.mediaplayerbackend.service;


import com.example.mediaplayerbackend.dto.MediaPlayerDto;
import com.example.mediaplayerbackend.model.MediaPlayerModel;

import java.util.List;
import java.util.Optional;

public interface MediaPlayerService {

    MediaPlayerModel saveMediaPlayer(MediaPlayerDto mediaPlayerDto);

    void deleteMediaPlayer(Long id);

    Optional<MediaPlayerDto> getMediaPlayerById(Long id);

    List<MediaPlayerDto> searchByTitle(String title);

    List<MediaPlayerDto> searchByArtist(String artist);

    List<MediaPlayerDto> listAllMediaPlayers();
}