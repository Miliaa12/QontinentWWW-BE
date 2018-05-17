package application.Controller;

import application.Model.Artist;
import application.View.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/artist")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping(path="/artistByScen/{scenId}")
    public @ResponseBody Iterable<Artist> getAllArtistGivenScenId(@PathVariable int scenId) {
        return artistRepository.findByScenId(scenId);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Artist> getAllArtist(){
        return artistRepository.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody String add(@RequestParam String name, @RequestParam Long time, @RequestParam int scenId) {
        Artist a = new Artist();
        a.setName(name);
        a.setTime(time);
        a.setScenId(scenId);
        artistRepository.save(a);

        return "ADDED";
    }
}
