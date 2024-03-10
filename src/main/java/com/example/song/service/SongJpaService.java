/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.song.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.song.repository.SongRepository;
import com.example.song.repository.SongJpaRepository;
import com.example.song.model.Song;

@Service
public class SongJpaService implements SongRepository {

    @Autowired
    private SongJpaRepository repository;

    @Override
    public ArrayList<Song> getSongs() {
        List<Song> list = repository.findAll();
        ArrayList<Song> songs = new ArrayList<>(list);

        return songs;
    }

    @Override
    public Song getSongsById(int songId) {
        try {
            Song songs = repository.findById(songId).get();
            return songs;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSongs(Song song) {
        repository.save(song);
        return song;
    }

    @Override
    public Song updateSongs(int songId, Song song) {
        try {
            Song songs = repository.findById(songId).get();
            if (song.getSongName() != null) {
                songs.setSongName(song.getSongName());
            }
            if (song.getLyricist() != null) {
                songs.setLyricist(song.getLyricist());
            }
            if (song.getSinger() != null) {
                songs.setSinger(song.getSinger());
            }
            if (song.getMusicDirector() != null) {
                songs.setMusicDirector(song.getMusicDirector());
            }

            repository.save(songs);
            return song;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteSongs(int songId) {
        repository.deleteById(songId);
    }
}