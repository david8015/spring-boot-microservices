package com.example.songsapi.controller;

import com.example.songsapi.models.Song;
import com.example.songsapi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/list")
    public Iterable<Song> getAll() {
        return songService.getSongs();
    }

    @GetMapping("/search/{id}")
    public Song searchBySongId(@PathVariable Long id) {
        return songService.searchBySongId(id);
    }

    @DeleteMapping("/delete/{songId}")
    public HttpStatus deleteSongBySongId(@PathVariable Long songId) {
        return songService.deleteSongBySongId(songId);
    }

    @PostMapping("/create")
    public HttpStatus createSong(@RequestBody Song Song) {
        songService.createSong(Song);
        return HttpStatus.OK;
    }

    @PatchMapping("/update/{id}")
    public HttpStatus updateSongBySongId(@PathVariable long id, @RequestBody Song songInfo) {
        songService.updateSongBySongId(id, songInfo);
        return HttpStatus.OK;
    }
}
