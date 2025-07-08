package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    public final List<Movie> movies = new ArrayList<>(){{
        add(new Movie("Prisoners",2013,"Dennis Villenvue", 153));
        add(new Movie("The Seventh Seal",1957,"Ingmar Bergman", 96));
        add(new Movie("The Crow",1994,"Alex Proyas", 102));

    }};

    @GetMapping("/json")
    public List<Movie> getMovieJson(){return movies;}

    @GetMapping("/html")
    public String getMovieHtml(){

        String movieList = "<ul>";

        for(Movie movie : movies){
            movieList += "<li>" + movie + "</li>";
        }

        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                """;
    }
}