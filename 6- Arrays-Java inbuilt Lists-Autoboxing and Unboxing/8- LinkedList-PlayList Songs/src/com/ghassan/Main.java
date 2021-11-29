package com.ghassan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    //This example is described in the Description text file
    //It tends to create a playlist f songs that are included in albums
    //This application should give the ability to skip forward or backward to the next or previous song
    //Replay the song
    // To provide this functionality we use the listIterator
    public static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album_1 = new Album("Album1", "Ghassan");
        album_1.addSong("Song 1_1", 4.2);
        album_1.addSong("Song 1_2", 4.2);
        album_1.addSong("Song 1_3", 2.2);
        album_1.addSong("Song 1_4", 3.1);
        album_1.addSong("Song 1_5", 3.3);
        album_1.addSong("Song 1_6", 2.34);
        album_1.addSong("Song 1_7", 2.34);
        album_1.addSong("Song 1_8", 4.11);

        Album album_2 = new Album("Album2", "Saliby");
        album_2.addSong("Song 2_1", 3.33);
        album_2.addSong("Song 2_2", 3.36);
        album_2.addSong("Song 2_3", 2.53);
        album_2.addSong("Song 2_4", 4.53);
        album_2.addSong("Song 2_5", 2.4);
        album_2.addSong("Song 2_6", 3.24);
        album_2.addSong("Song 2_7", 4.33);
        album_2.addSong("Song 2_8", 2.55);

        albums.add(album_1);
        albums.add(album_2);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("Song 1_4", playList);
        albums.get(0).addToPlayList("Song 1_5", playList);
        albums.get(0).addToPlayList("Song 1_6", playList);
        albums.get(0).addToPlayList("Song 1_8", playList);
        albums.get(1).addToPlayList("Song 2_4", playList);
        albums.get(1).addToPlayList("Song 2_1", playList);
        albums.get(1).addToPlayList("Song 2_3", playList);
        albums.get(1).addToPlayList("Song 2_6", playList);
        albums.get(1).addToPlayList("Song 2_7", playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(0).addToPlayList("Song 4_4", playList);
        albums.get(0).addToPlayList(10, playList);

        //Press 1 for next song, 2 for previous song amd 0 for Exit.
        play(playList);

    }

    public static void play (LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator listIterator = playList.listIterator();
        if(playList.size() == 0 ){
            System.out.println("The playlist is empty");
            return;
        }
        else {
            System.out.println("Now playing "+ listIterator.next().toString());
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("PlayList complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Playing "+ listIterator.next().toString());
                    }else {
                        System.out.println("End of the List");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Playing "+ listIterator.previous().toString());
                    }else {
                        System.out.println("Beginning of the list");
                        forward = true;
                    }
                    break;
            }
        }
    }
}
