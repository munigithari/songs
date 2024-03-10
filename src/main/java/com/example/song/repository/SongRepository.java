// Write your code here
package com.example.song.repository;

import com.example.song.model.Song;
import java.util.*;

public interface SongRepository {
    ArrayList<Song> getSongs();

    Song getSongsById(int songId);

    Song addSongs(Song song);

    Song updateSongs(int songId, Song song);

    void deleteSongs(int songId);
}