package application.Controller;


import application.Model.Scene;
import application.View.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/scene")
public class SceneController {
    @Autowired
    private SceneRepository sceneRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Scene> getAllScenes() {
        return sceneRepository.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody String addScene(@RequestParam String sceneName) {
        Scene s = new Scene();
        s.setName(sceneName);
        sceneRepository.save(s);
        return "ADDED";
    }
}
