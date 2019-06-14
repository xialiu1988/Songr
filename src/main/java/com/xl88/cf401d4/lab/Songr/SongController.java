package com.xl88.cf401d4.lab.Songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;


    @GetMapping("/songs")
    public String getAllSongs(Model m){
        Iterable<Song> songs=songRepository.findAll();
        m.addAttribute("songs",songs);
      return "allSongs";
    }



}
