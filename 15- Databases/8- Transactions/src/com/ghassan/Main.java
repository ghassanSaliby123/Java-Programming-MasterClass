package com.ghassan;

import com.ghassan.model.Artist;
import com.ghassan.model.DataSource;
import com.ghassan.model.SongArtist;
import java.util.List;
import java.util.Scanner;


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
    // *********************************************************************************
    //************************** SQL Injection Attacks *********************************
    // *********************************************************************************
    //Sql injection attacks: since our statements are concatenating strings and the Statement class will
    //always compile the string to check if it has the proper syntax. The attacker might enter a string
    //that represent a statement which expose our database
    //In the example below, we ask the user to enter a song title to query the artists in our view table
    //for example the user wants to know the artists for the Heartless song
    //So he can type:(Heartless" or 1=1 or") since our application will concatenate this entry to our
    //pre-defined statements and create a new one, the statement will be
    //SELECT name, album,track FROM artist_list WHERE title = "Heartless" or 1=1
    //Since 1=1 is always true, this statement will query all the records in or table and in this way
    //our database will be exposed
    //****************************** Solution ******************************************
    //Instead of building uo query strings and using the Statement class to execute them, we use
    //the prepared statement class which can protect our application against SQL injection attacks
    //THE reason of that, when we use Prepared Statement class we don't concatenate user's input
    //into the sql statement that will be running.
    //It uses a placeholder character (?) for the values that might change in the sql statement
    //for the previous example the value is the (title)
    //SELECT name, album,track FROM artist_list WHERE title = ?
    //Then we want to execute the query we replace the placeholder ? by the actual title
    //Then we create an instance variable PreparedStatement adn we instantiated in the open method
    //preparedStatement = connection.preparedStatement(the statement with the placeholder)
    //Then we set the position of the placeHolder which always starts with 1.
    // We do that because we might have several placeholders
    //preparedStatement.setString(1,title)
    //ResultSet r = preparedStatement.executeQuery()
    //Then we close the preparedStatement
    // *********************************************************************************
    //********************************* Transactions ***********************************
    // *********************************************************************************
    //JDBC Connection Class auto commits changes by default when we call execute()
    //but often we don't need that. For example:
    //When we want to add a song to songs table we have to add its album to the albums table,thus we need
    //to add artist to the artists table.
    //In case of failure with adding album or artist the song will be added without album or artist
    //To solve this we use Transactions which are sequence of sql statements that are treated as a single
    //logical unit. if any of the statements fail the result of previous statements can be rolled back or
    //not saved
    //Database transactions must be ACID- compliant:
    //  -Atomicity: as mentioned before
    //  -Consistency: before transaction begins the DB in a valid state. when it completes DB should still
    //  valid
    //  -Isolation: Transactions can't depend on each other
    //  -Durability: once the changes performed by a transaction are committed to DB they are permanent
    //Transactions with sqlite:
    //  -BEGIN TRANSACTION : manually starts transaction
    //  -END TRANSACTION:  end the transaction same as COMMIT
    //  -COMMIT: commit changes by the transaction and ends it
    //  -ROLLBACK: rolls back any uncommitted changes and ends transaction
    //We perform Transactions in our application by the following steps:
    //1- turn off the autoCommit from the Connection object Connection.setAutoCommit(false)
    //2- Perform the sql operations
    //3- if there are no errors we call Connection.commit(). If there are errors we call Connection.rollback()
    //4- turn on auto commit again
    //The methods for transactions are: insertArtist, insertAlbum and insertSong

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();
        songArtists = dataSource.querySongInfoView(title);
        if (songArtists.isEmpty()){
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        for (SongArtist songArtist : songArtists) {
            System.out.println("From VIEW - Artist name = "+ songArtist.getArtistName() +
                    ", Album name = "+ songArtist.getAlbumName() + ", Track number = "+ songArtist.getTrack());
        }
        System.out.println("----------------------------------------------------");
        dataSource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark",1);
        dataSource.close();
    }
}
