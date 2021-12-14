package com.ghassan;

import com.ghassan.model.Artist;
import com.ghassan.model.DataSource;
import com.ghassan.model.SongArtist;
import java.util.List;


public class Main {

    //This application illustrates the CRUD operations (Create, Read, Update,Delete )
    //on a music database whiCh is consists of three tables (artists, albums, songs)
    //The DataSource class provides the connection details to tha DB and it has the following functions:
    //1-queryArtists:  we can query all the artists through queryArtists method which returns a
    // sorted results by name. it takes one argument for sorting method (1 for none- 2 for ASC- 3 for DESC)
    //2-queryAlbumsForArtist: gets albums for an artist, it gets the artist name and the sorting
    //3- queryArtistsForSong: gets artists for a song, it takes 2 args the song name and the sort
    //4- querySongsMetadata: gets the schema information about tables. we use it through the ResultSet.
    //5- getCount: applies the COUNT() function within the statement. We use it to get the songs count in
    //songs table.
    //6- createViewForSongArtists: creates a view for songs_artist
    //7- querySongInfoView: to query the view
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()){
            System.out.println("Can't open datasource");
            return;
        }
        List<Artist> artists = dataSource.queryArtists(2);
        if (artists == null){
            System.out.println("No artists");
            return;
        }
        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = "+ artist.getName());
        }
        System.out.println("----------------------------------------------------");
        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Iron Maiden",
                DataSource.ORDER_BY_ASC);
        if (albumsForArtist == null){
            System.out.println("Couldn't find albums for the artist");
        }
        for (String s : albumsForArtist) {
            System.out.println(s);
        }
        System.out.println("----------------------------------------------------");

        List<SongArtist> songArtists = dataSource.queryArtistsForSong("Heartless",DataSource.ORDER_BY_ASC);
        if (songArtists == null){
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        for (SongArtist songArtist : songArtists) {
            System.out.println("Artist name: "+songArtist.getArtistName()+
                    ", Album name: "+songArtist.getAlbumName()+
                    ", Track: "+ songArtist.getTrack());
        }
        System.out.println("----------------------------------------------------");
        dataSource.querySongsMetadata();
        System.out.println("----------------------------------------------------");
        int count= dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of songs is :" + count);
        System.out.println("----------------------------------------------------");
        dataSource.createViewForSongArtists();
        System.out.println("----------------------------------------------------");
        songArtists = dataSource.querySongInfoView("Circle Dream");
        if (songArtists.isEmpty()){
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        for (SongArtist songArtist : songArtists) {
            System.out.println("From VIEW - Artist name = "+ songArtist.getArtistName() +
                    ", Album name = "+ songArtist.getAlbumName() + ", Track number = "+ songArtist.getTrack());
        }
        dataSource.close();
    }
}
