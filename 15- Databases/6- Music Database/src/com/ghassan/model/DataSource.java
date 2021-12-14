package com.ghassan.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//the index always starts with 1
//It is the index of the resultSet not the table
public class DataSource {
    public static final String DB_NAME = "music.db";
    //The connection string
    //dbc:sqlite:D:\Java Programming MasterClass Java11&java17\15- Databases
    //  \7- SQL Injection and Prepared Statements\music.db;
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Java Programming MasterClass Java11&java17" +
            "\\15- Databases\\6- Music Database\\" + DB_NAME;

    //The Albums table fields name and index
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    //The artists table fields name and index
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    //The Songs table fields name and index
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    //The sorting
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    //SELECT artists.name, albums.name, songs.track FROM songs INNER JOIN albums
    //ON songs.album = albums._id INNER JOIN artists ON albums.artist = artists._id
    //WHERE songs.title = ""
    public static final String QUERY_ARTIST_FOR_SONG_START =
            "SELECT "+ TABLE_ARTISTS+"."+COLUMN_ARTIST_NAME+","+
                    TABLE_ALBUMS+"."+COLUMN_ALBUM_NAME+","+
                    TABLE_SONGS+"."+COLUMN_SONG_TRACK+" FROM "+
                    TABLE_SONGS+ " INNER JOIN "+ TABLE_ALBUMS + " ON "+
                    TABLE_SONGS+"."+COLUMN_SONG_ALBUM+"="+TABLE_ALBUMS+
                    "."+COLUMN_ALBUM_ID +" INNER JOIN "+TABLE_ARTISTS+
                    " ON "+ TABLE_ALBUMS+"."+COLUMN_ALBUM_ARTIST+"="+
                    TABLE_ARTISTS+"."+COLUMN_ARTIST_ID+ " WHERE "+
                    TABLE_SONGS+"."+COLUMN_SONG_TITLE+ "= \"";

    //This is for sorting:
    //ORDER BY artists.name, albums.name COLLATE NOCASE
    public static final String QUERY_ARTIST_FOR_SONG_SORT=
            " ORDER BY "+TABLE_ARTISTS+"."+COLUMN_ARTIST_NAME+","+
                    TABLE_ALBUMS+"."+COLUMN_ALBUM_NAME+" COLLATE NOCASE ";

    //The name of the VIEW
    public static final String TABLE_ARTIST_SONG_VIEW= "artist_list";

    //CREATE VIEW IF NOT EXIST artist_list AS SELECT artists.name, albums.name AS album,
    //songs.track, songs.title FROM songs INNER JOIN albums ON songs.album = albums._id
    //INNER JOIN artists ON albums.artist = artists._id ORDER BY artists.name, albums.name, songs.track
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
            " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS +
            "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " ORDER BY " + TABLE_ARTISTS + "." +
            COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK;

    //SELECT name, album,track FROM artist_list WHERE title = ""
    public static final String QUERY_VIEW_SONG_INFO =  "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = \"";

    //instance variable for connection
    private Connection connection;
    //Open a connection
    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Could not connect to the database: " + e.getMessage());
            return false;
        }
    }

    //Close the connection
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Could not close the connection: " + e.getMessage());
        }
    }

    //Get a List of artists
    public List<Artist> queryArtists(int sortOrder) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE");
            if (sortOrder == ORDER_BY_DESC){
                sb.append(" DESC");
            }else {
                sb.append(" ASC");
            }
        }
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //Create a statement then get the resultSet through executing a query
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sb.toString());
            //Creating a list of artist then set the fields for each artist then add the artist to
            //artists list
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                artists.add(artist);

            }
            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet: " + e.getMessage());
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Could not close the statement: " + e.getMessage());
            }
        }
    }

    //Get the albums for an Artist
    public List<String> queryAlbumsForArtist(String artistName, int sortOrder){
        //SELECT albums.name FROM albums INNER JOIN artists on albums.artist = artists._id
        //WHERE artists.name = "Iron Maiden" ORDER by albums.name COLLATE NOCASE ASC
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(TABLE_ALBUMS);
        sb.append(".");
        sb.append( COLUMN_ALBUM_NAME);
        sb.append(" FROM ");
        sb.append(TABLE_ALBUMS);
        sb.append(" INNER JOIN ");
        sb.append(TABLE_ARTISTS);
        sb.append(" ON ");
        sb.append(TABLE_ALBUMS);
        sb.append(".");
        sb.append(COLUMN_ALBUM_ARTIST);
        sb.append(" = ");
        sb.append(TABLE_ARTISTS);
        sb.append(".");
        sb.append(COLUMN_ARTIST_ID);
        sb.append(" WHERE ");
        sb.append(TABLE_ARTISTS);
        sb.append(".");
        sb.append(COLUMN_ARTIST_NAME);
        sb.append(" =\"");
        sb.append(artistName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(TABLE_ALBUMS);
            sb.append(".");
            sb.append(COLUMN_ALBUM_NAME);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else {
                sb.append("ASC");
            }
        }
        System.out.println("SQL statement = " + sb.toString());
        try(Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sb.toString())){
            List<String> albums = new ArrayList<>();
            while (resultSet.next()){
                albums.add(resultSet.getString(1));
            }
            return albums;
        }catch (SQLException e){
            System.out.println("Query failed: "+ e.getMessage());
            return null;
        }
    }

    //get artists for a song
    public List<SongArtist> queryArtistsForSong(String songName, int sortOrder){
        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        sb.append(songName);
        sb.append("\"");
        if (sortOrder != ORDER_BY_NONE){
            sb.append(QUERY_ARTIST_FOR_SONG_SORT);
            if (sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            }else {
                sb.append("ASC");
            }
        }
        System.out.println("SQL statement: "+ sb.toString());

        try(Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sb.toString())){
            List<SongArtist> songArtists = new ArrayList<>();
            while (resultSet.next()){
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(resultSet.getString(1));
                songArtist.setAlbumName(resultSet.getString(2));
                songArtist.setTrack(resultSet.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        }catch (SQLException e){
            System.out.println("Query failed: "+ e.getMessage());
            return null;
        }

    }

    //Get meta data about the table such as .schema in sql
    public void querySongsMetadata(){
        String sql = "SELECT * FROM "+ TABLE_SONGS;
        try(Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numColumns = metaData.getColumnCount();
            for (int i = 1 ; i <= numColumns ; i++) {
                System.out.format("Column %d in songs table is named %s\n",i,metaData.getColumnName(i));
            }
        }catch (SQLException e){
            System.out.println("Query failed: "+ e.getMessage());
        }
    }

    //Executing statements that contain functions such as count()
    public int getCount(String table){
        String sql = "SELECT COUNT(*) AS count FROM "+table;
        try(Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            int count = resultSet.getInt("count");
            return count;
        }catch (SQLException e){
            System.out.println("Query failed: "+e.getMessage());
            return -1;
        }
    }

    //create a view for songs_artist
    public boolean createViewForSongArtists(){
        try(Statement statement= connection.createStatement()){
            statement.executeQuery(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;
        }catch(SQLException e){
            System.out.println("Create view failed: "+e.getMessage());
            return false;
        }
    }
    //Query a view
    public List<SongArtist> querySongInfoView(String title){
        StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO);
        sb.append(title);
        sb.append("\"");

        System.out.println("The query for the view is:" + sb.toString());
        try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sb.toString())){
            List<SongArtist> songArtists = new ArrayList<>();
            while (resultSet.next()){
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(resultSet.getString(1));
                songArtist.setAlbumName(resultSet.getString(2));
                songArtist.setTrack(resultSet.getInt(3));
            }
            return songArtists;
        }catch (SQLException e){
            System.out.println("Query the view failed:" + e.getMessage());
            return null;
        }
    }
}
