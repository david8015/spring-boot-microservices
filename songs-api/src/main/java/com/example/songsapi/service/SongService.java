package com.example.songsapi.service;

import com.example.songsapi.models.Song;
import org.springframework.http.HttpStatus;

public interface SongService{
    public Iterable<Song> getSongs();
    public Song searchBySongId(Long songId);
    public HttpStatus deleteSongBySongId(Long songId);
    public HttpStatus createSong(Song song);
    public HttpStatus updateSongBySongId(Long songId,Song songInfo);
}
