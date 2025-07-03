package vn.duy.java.nestedClass.selfChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private final SongList songs = new SongList();

    public static class SongList {
        private ArrayList<Song> songs =  new ArrayList<>();

        private SongList() {
        }

        private boolean add(Song song) {
            if (findSong(song.getTitle()) != null) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title) {
            for (Song song : songs) {
                if (song.getTitle().equalsIgnoreCase(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int position = trackNumber - 1;
            if (position >= 0 && position < songs.size()) {
                return songs.get(position);
            }
            return null;
        }
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String songTitle, double duration) {
        Song existingSong = this.songs.findSong(songTitle);
        if (existingSong != null) {
            return false;
        }
        Song newSong = new Song(songTitle, duration);
        this.songs.add(newSong);
        return true;
    }

    public boolean addToPlayList(String titleOfSong, LinkedList<Song> playList) {
        Song existingSong = this.songs.findSong(titleOfSong);
        if (existingSong != null) {
            playList.add(existingSong);
            return true;
        }
        System.out.printf("The song %s is not in this album%n", titleOfSong);
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if (this.songs.findSong(trackNumber) != null) {
            playList.add(this.songs.songs.get(index));
            return true;
        }
        System.out.printf("This album does not have a track %d%n", trackNumber);
        return false;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                '}' + this.songs.songs;
    }

    public static void main(String[] args) {
        List<Album> albums = new ArrayList<>();
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);

        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        for (Album album1 : albums) {
            System.out.println(album1);
        }

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24
    }
}
