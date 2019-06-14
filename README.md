# **Songr**


This app is built with Spring framework using java

It has three routes:

/hello                             return "Hello, World";


/capitalize/{sentence}              will return all capital letters of the input sentence


/reverse?sentence=Hello world      will reverse the words position in the input sentence


/albums    display all albums from the database and has a herf link to link to the form to add new album

/album     create new album and save to database and redirect to the home page after add the new album

/songs      display all the songs on the page

/albumDetail/{id}  get one album detail with all the details including songs in the album


How to run:
1. ./gradlew bootRun

2. open your browser type: localhost:8080

3. type any routes you want to test for

  e.g localhost:8080/hello
      you should see "Hello, World" on the page
      
 
run the app and go to localhost:8080/albums 

Home page route: /albums
 
View all songs-- display all songs 

Create new Album -- create new album

for each album there is link to view details about that specific album.

in the album detail page-- you are able to add one song to this album 

