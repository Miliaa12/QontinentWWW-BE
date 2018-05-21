package application.Controller;

import application.Model.Artist;
import application.View.ArtistRepository;
import errors.ArtistNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/artist")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    private Logger l = LoggerFactory.getLogger(ArtistController.class);

    @GetMapping(path="/artistByScene/{sceneId}")
    public @ResponseBody Iterable<Artist> getAllArtistGivenScenId(@PathVariable int sceneId) {
        Iterable<Artist> retValue = artistRepository.findBySceneId(sceneId);

        if(!retValue.iterator().hasNext()) throw new ArtistNotFoundException();

        return retValue;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Artist> getAllArtist(){
        Iterable<Artist> retValue = artistRepository.findAll();
        if(!retValue.iterator().hasNext()) throw new ArtistNotFoundException();
        return retValue;
    }

    @PostMapping(path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String add(@RequestParam String name, @RequestParam Long time, @RequestParam int sceneId) {
        try {
            Artist a = new Artist();
            a.setName(name);
            a.setTime(time);
            a.setSceneId(sceneId);
            artistRepository.save(a);
            l.info("Added: " + a.toString());
        }
        catch(Exception e) {
            l.error("Failed to add Artist: " + e.toString());
        }
        return "ADDED";
    }
}
