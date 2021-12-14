This section provides illustrations to work with Database and it covers the following topics:
1- Introduction to SQLITE and make queries to the music db
2- Using sqilte jdbc and to open a connection to the db and make statements.
  a- The connection can be established through the DriverManager or the DataSource 
  b- Through the connection class we create statements and execute then
3- Doing the CRUD operations (create, read, update and delete) through sql statements (insert, select, update, delete)
4- Using the ResultSet to manipulate the results of the sql queries
5- Creating an application to query the music DB which is consists of three tables (artists, albums, songs) and this application has the following functionalities:
  a- queryArtists:  we can query all the artists through queryArtists method which returns a sorted results by name. it takes one argument for
  sorting method (1 for none- 2 for ASC- 3 for DESC)
  b- queryAlbumsForArtist: gets albums for an artist, it gets the artist name and the sorting
  c- queryArtistsForSong: gets artists for a song, it takes 2 args the song name and the sort
  d- querySongsMetadata: gets the schema information about tables. we use it through the ResultSet.
  e- getCount: applies the COUNT() function within the statement. We use it to get the songs count in songs table.
  f- createViewForSongArtists: creates a view for songs_artist
  g- querySongInfoView: to query the view
6- Dealing with Sql injections attacks through the PreparedStatement interface which extends the Statement interface
  a- put the placeholders in our sql statements (which will be treated as literals) such as
      SELECT name, album,track FROM artist_list WHERE title = ?
  b- create a preparedStatement for this query: connection.prepareStatement()
  c- Then we set the position for the placeholder beacuse we might have several ones in the same statement 
    preparedStatement.setString()/setInt()...
  d- Get the result through ResultSet = preparedStatement.execute()/executeQueries()/executeUpdates()
  e- process the resultSet and get the records
  f- close the statements and the connection with the database
7- Covering Transactions- commit- rollback though a song insert example
  
