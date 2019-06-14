package com.xl88.cf401d4.lab.Songr;

//import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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

     @GetMapping("/updatesong/{id}")
    public String updateSong(@PathVariable Long id,Model m){

         Song s = songRepository.findById(id).get();
         m.addAttribute("oneSong",s);
         return "songDetail";

     }

     //updating song
    @PostMapping("/updatesong/{id}")
    public String update(@PathVariable Long id, @RequestParam int length,@RequestParam int trackNumber){
        Song s = songRepository.findById(id).get();
         s.length=length;
         s.trackNumber=trackNumber;
           songRepository.save(s);
           System.out.println(s.length);
        return "redirect:/songs";

    }

    @GetMapping("/deletesong/{id}")
    public String delete(@PathVariable Long id){
        Song s = songRepository.findById(id).get();
        songRepository.delete(s);
        return "redirect:/songs";
    }

}
