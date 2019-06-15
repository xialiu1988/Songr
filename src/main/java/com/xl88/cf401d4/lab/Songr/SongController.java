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

   @Autowired
   AlbumRepository albumRepository;
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
    public String update(@PathVariable Long id,@RequestParam String title, @RequestParam int length,@RequestParam int trackNumber){
        Song s = songRepository.findById(id).get();
          s.setTitle(title);
          s.setLength(length);
          s.setTrackNumber(trackNumber);
           songRepository.save(s);

           //update album length
        int total=0;
         for(Song n:s.album.songs)  {
             total+=n.length;
         }
           s.album.setLength(total);

         albumRepository.save(s.album);

           System.out.println(s.length);
        return "redirect:/songs";

    }

    @GetMapping("/deletesong/{id}")
    public String delete(@PathVariable Long id){
        Song s = songRepository.findById(id).get();
        songRepository.delete(s);
        //after delete song update album songcount
        s.album.setSongCount(s.album.songs.size());

        //update album length
        int total=0;
        for(Song n:s.album.songs)  {
            total+=n.length;
        }
        s.album.setLength(total);

        albumRepository.save(s.album);

        return "redirect:/songs";
    }

}
