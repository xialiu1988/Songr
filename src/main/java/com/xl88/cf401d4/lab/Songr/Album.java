package com.xl88.cf401d4.lab.Songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;
@OneToMany(mappedBy = "album")
   List<Song> songs;
    public Album(){}
    public Album(String title,String artist,int songCount,int length,String imageUrl){
      this.title = title;
      this.artist=artist;
      this.songCount=songCount;
      this.length = length;
      this.imageUrl=imageUrl;
    }



    //getters
    public  long getId(){return id;}
    public String getTitle(){ return title; }

    public String getArtist(){
        return artist;
    }

    public int getSongCount(){
        return songCount;
    }

    public int getLength(){
        return length;
    }

    public String getImageUrl(){
        return imageUrl;
    }


    public List<Song> getSongs(){return songs;}
    //setters
    public void setTitle(String title){
        this.title=title;
    }
    public void setArtist(String artist){
        this.artist=artist;
    }
    public void setSongCount(int songCount){
        this.songCount=songCount;
    }
    public void setLength(int length){
        this.length=length;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
    }


}
