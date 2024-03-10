/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here

package com.example.song.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.example.song.model.Song;
import com.example.song.service.SongJpaService;

@RestController
public class SongController {

    @Autowired
    private SongJpaService service;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return service.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongsById(@PathVariable("songId") int songId) {
        return service.getSongsById(songId);
    }

    @PostMapping("/songs")
    public Song addSongs(@RequestBody Song song) {
        return service.addSongs(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSongs(@PathVariable("songId") int songId, @RequestBody Song song) {
        return service.updateSongs(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSongs(@PathVariable("songId") int songId) {
        service.deleteSongs(songId);
    }
}