package com.example.mediaplayerbackend.repo;

import com.example.mediaplayerbackend.model.MediaPlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MediaPlayerRepository extends JpaRepository<MediaPlayerModel, Long>, JpaSpecificationExecutor<MediaPlayerModel> {

    List<MediaPlayerModel> findByTitle(String title);

    List<MediaPlayerModel> findByArtist(String artist);

    Optional<MediaPlayerModel> findById(Long id);

    <S extends MediaPlayerModel> S save(S entity);

    void deleteById(Long id);

    List<MediaPlayerModel> findAll();
}