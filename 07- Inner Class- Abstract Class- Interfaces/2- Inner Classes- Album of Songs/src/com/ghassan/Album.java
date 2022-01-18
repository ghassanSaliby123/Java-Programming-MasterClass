package com.ghassan;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
      return this.songs.add(new Song(title,duration));
    }



    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song song = this.songs.findSong(trackNumber);
        if(song != null){
            playList.add(song);
            return true;
        }
        System.out.println("This album doesnt have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = this.songs.findSong(title);;
        if (song != null) {
            playList.add(song);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    //Defining inner class
    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = songs;
        }
        public boolean add(Song song){
            if (this.songs.contains(song)){
                return false;
            }else {
                this.songs.add(song);
                return true;
            }
        }

        private Song findSong(String title) {
            for (Song song : this.songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index >= 0) && (index <= this.songs.size())) {
                return this.songs.get(index);
            }
            return null;
        }
    }
}
