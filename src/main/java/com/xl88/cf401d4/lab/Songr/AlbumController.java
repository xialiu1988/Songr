package com.xl88.cf401d4.lab.Songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getALlalbums(Model m){
     Iterable<Album> albums=albumRepository.findAll();
     m.addAttribute("albums",albums);
     return "allAlbums";
    }



    //good example--my reference
    //https://stackoverflow.com/questions/22794057/thymeleaf-send-parameter-from-html-to-controller
   //get details of a single album by id
    //old way
    @RequestMapping(value="albumDetail/{id}",method = RequestMethod.GET)
    public String getOneAlbumDetail(@PathVariable Long id,Model m){
        Album a = albumRepository.findById(id).get();
        m.addAttribute("albumdetail",a);
        m.addAttribute("newsong",new Song());
        return "albumDetail";
    }



    @PostMapping("albumDetail/{id}")
    public String getOneAlbumDetail(@PathVariable Long id,@RequestParam String title,@RequestParam int length,@RequestParam int trackNumber){
        //get the album where new song wants to add in
        Album a = albumRepository.findById(id).get();
        //create a new song
        //update songCount in the album
        //calculate the length of all the songs
        if(!a.songs.isEmpty()) {
            Song newsong= new Song(title,length,trackNumber,a);
            songRepository.save(newsong);
            int totalLength = 0;
            for (Song s : a.songs) {
                totalLength = totalLength + s.length;
            }
            a.setLength(totalLength+newsong.length);
            a.setSongCount(a.songs.size()+1);
            System.out.println("running");
        }
        else {
            Song newsong= new Song(title,length,trackNumber,a);
            songRepository.save(newsong);
            a.setLength(newsong.length);
            a.setSongCount(1);
        }

        albumRepository.save(a);
        return "redirect:/albumDetail/{id}";
    }




    /**
     * reference:https://spring.io/guides/gs/serving-web-content/
     *Modle @param
     *the html called"album" as string @return
     */
    @GetMapping("/album")
    public String albumCreate(Model m){
        m.addAttribute("album",new Album());
        return "album";
    }

   @PostMapping("/album")
    public String albumSubmit(@ModelAttribute Album album){
        albumRepository.save(album);
       return "redirect:/albums";
   }
}
