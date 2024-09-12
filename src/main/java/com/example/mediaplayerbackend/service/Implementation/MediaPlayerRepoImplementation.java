package com.example.mediaplayerbackend.service.Implementation;

import com.example.mediaplayerbackend.dto.MediaPlayerDto;
import com.example.mediaplayerbackend.model.MediaPlayerModel;
import com.example.mediaplayerbackend.repo.MediaPlayerRepository;
import com.example.mediaplayerbackend.service.MediaPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Component
public class MediaPlayerRepoImplementation implements MediaPlayerService {
    @Autowired
    private MediaPlayerRepository mediaPlayerRepository;

    @Override
    public MediaPlayerModel saveMediaPlayer(MediaPlayerDto mediaPlayerDto) {
        MediaPlayerModel mediaPlayerModel = new MediaPlayerModel(
                mediaPlayerDto.getTitle(),
                mediaPlayerDto.getArtist(),
                mediaPlayerDto.getAlbum(),
                mediaPlayerDto.getGenre(),
                mediaPlayerDto.getDuration(),
                mediaPlayerDto.getMp3Data(),
                mediaPlayerDto.getYear(),
                mediaPlayerDto.getLyrics(),
                mediaPlayerDto.getCoverPath());
        return mediaPlayerRepository.save(mediaPlayerModel);
    }

    @Override
    public void deleteMediaPlayer(Long id) {
        mediaPlayerRepository.deleteById(id);
    }

    @Override
    public Optional<MediaPlayerDto> getMediaPlayerById(Long id) {
        Optional<MediaPlayerModel> mediaPlayer = mediaPlayerRepository.findById(id);
        // You'll need to map the MediaPlayerModel to MediaPlayerDto here
        return mediaPlayer.map(this::mapToDto); // Or use a mapping library
    }

    // Search
    @Override
    public List<MediaPlayerDto> searchByTitle(String title) {
        List<MediaPlayerModel> mediaPlayers = mediaPlayerRepository.findByTitle(title);
        // Map the List<MediaPlayerModel> to List<MediaPlayerDto> here
        return mediaPlayers.stream().map(this::mapToDto).toList(); // Or use a mapping library
    }

    @Override
    public List<MediaPlayerDto> searchByArtist(String artist) {
        List<MediaPlayerModel> mediaPlayers = mediaPlayerRepository.findByArtist(artist);
        // Map the List<MediaPlayerModel> to List<MediaPlayerDto> here
        return mediaPlayers.stream().map(this::mapToDto).toList(); // Or use a mapping library
    }

    @Override
    public List<MediaPlayerDto> listAllMediaPlayers() {
        List<MediaPlayerModel> mediaPlayers = mediaPlayerRepository.findAll();
        // Map the List<MediaPlayerModel> to List<MediaPlayerDto> here
        return mediaPlayers.stream().map(this::mapToDto).toList(); // Or use a mapping library
    }

    private MediaPlayerDto mapToDto(MediaPlayerModel mediaPlayerModel) {
        return MediaPlayerDto.builder()
                .id(mediaPlayerModel.getId())
                .title(mediaPlayerModel.getTitle())
                .artist(mediaPlayerModel.getArtist())
                .album(mediaPlayerModel.getAlbum())
                .genre(mediaPlayerModel.getGenre())
                .duration(mediaPlayerModel.getDuration())
                .mp3Data(mediaPlayerModel.getMp3Data())
                .trackCount(mediaPlayerModel.getTrackCount())
                .year(mediaPlayerModel.getYear())
                .lyrics(mediaPlayerModel.getLyrics())
                .coverPath(mediaPlayerModel.getCoverPath())
                .build();
    }
}