package vn.duy.java.linkedList.selfChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs = new ArrayList<>();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String songTitle, double duration) {
        Song existingSong = this.findSong(songTitle);
        if (existingSong != null) {
            return false;
        }
        Song newSong = new Song(songTitle, duration);
        this.songs.add(newSong);
        return true;
    }

    private Song findSong(String titleOfSong) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(titleOfSong)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(String titleOfSong, LinkedList<Song> playList) {
        if (findSong(titleOfSong) != null) {
            playList.add(findSong(titleOfSong));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {

        int index = trackNumber - 1;
        if ((index >= 0) && (index <= songs.size())) {
            playList.add(songs.get(index));
            return true;
        }
        return false;
    }
}
