package com.example.springboot_13;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String loadData(Model model){
        Actor actor= new Actor();
        actor.setName("Scoopty Woop");
        actor.setRealname("Woopidy scoop woop poop");
        actorRepository.save(actor);

        Movie movie=new Movie();

        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("about kanye west at his kanyes best");
        movieRepository.save(movie);

        actor.addMovie(movie);
        actorRepository.save(actor);
        model.addAttribute("oactors", actorRepository.findAll());
        return "index";
    }

}
