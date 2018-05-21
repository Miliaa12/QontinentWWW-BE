package application.Controller;

import application.Model.Artist;
import application.View.ArtistRepository;
import errors.ArtistNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/artist")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

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
        Artist a = new Artist();
        a.setName(name);
        a.setTime(time);
        a.setSceneId(sceneId);
        artistRepository.save(a);

        return "ADDED";
    }
}
