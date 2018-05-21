package application.Controller;


import application.Model.Scene;
import application.View.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(path="/scene")
public class SceneController {
    @Autowired
    private SceneRepository sceneRepository;
    Logger l = LoggerFactory.getLogger(SceneController.class);

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Scene> getAllScenes() {
        return sceneRepository.findAll();
    }

    @PostMapping(path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addScene(@RequestParam String sceneName) {
        try {
            Scene s = new Scene();
            s.setName(sceneName);
            sceneRepository.save(s);
            l.info("Added: " + s.toString());
        }
        catch(Exception e) {
            l.error("Failed to add Scene: " + e.toString());
        }
        return "added";
    }
}
