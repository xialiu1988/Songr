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

    @GetMapping("/albums")
    public String getALlalbums(Model m){

     Iterable<Album> albums=albumRepository.findAll();
     m.addAttribute("albums",albums);
     return "allAlbums";
    }

   //get details of a single album by id
    @RequestMapping(value="albumDetail/{id}",method = RequestMethod.GET)
    public String getOneAlbumDetail(@PathVariable Long id,Model m){
        Album a = albumRepository.findById(id).get();
        m.addAttribute("albumdetail",a);
        return "albumDetail";
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
