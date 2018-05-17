package application.Controller;


import application.Model.Scen;
import application.View.ArtistRepository;
import application.View.ScenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/scen")
public class ScenController {
    @Autowired
    private ScenRepository scenRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Scen> getAllScens() {
        return scenRepository.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody String addScen(@RequestParam String scenName) {
        Scen s = new Scen();
        s.setName(scenName);
        scenRepository.save(s);
        return "ADDED";
    }
}
