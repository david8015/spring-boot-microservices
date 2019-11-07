package com.example.songsapi.service;

import com.example.songsapi.models.Song;
import com.example.songsapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    SongRepository songRepository;

    @Override
    public Iterable<Song> getSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song searchBySongId(Long songId) {
        return songRepository.findById(songId).get();
    }

    @Override
    public HttpStatus deleteSongBySongId(Long songId) {
        songRepository.deleteById(songId);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus createSong(Song song){
        songRepository.save(song);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateSongBySongId(Long songId, Song songInfo) {
        Song song = songRepository.findById(songId).get();
        song.setTitle(songInfo.getTitle());
        song.setLength(songInfo.getLength());
        songRepository.save(song);
        return HttpStatus.OK;
    }
}
