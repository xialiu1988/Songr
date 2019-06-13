package com.xl88.cf401d4.lab.Songr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String artist;
    int songCount;
    String length;
    String imageUrl;


    public Album(){}
    public Album(String title,String artist,int songCount,String length,String imageUrl){
      this.title = title;
      this.artist=artist;
      this.songCount=songCount;
      this.length = length;
      this.imageUrl=imageUrl;
    }



    //getters
    public String getTitle(){
        return this.title;
    }

    public String getArtist(){
        return this.artist;
    }

    public int getSongCount(){
        return this.songCount;
    }

    public String getLength(){
        return this.length;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

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
    public void setLength(String length){
        this.length=length;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
    }


}
