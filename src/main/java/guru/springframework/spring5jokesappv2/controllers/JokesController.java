package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Controller
public class JokesController {

    private final JokeService jokeService;
    private Logger logger = LogManager.getLogger();

    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String index(Model model){

        model.addAttribute("joke", jokeService.getRandomJoke());

        logger.info(model.getAttribute("joke"));

        return "index";
    }
}
