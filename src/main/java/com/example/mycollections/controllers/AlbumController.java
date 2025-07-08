package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final List<Album> albums = new ArrayList<>(){{
        add(new Album("The Fragile",1999,"Nine Inch Nails",23));
        add(new Album("I Didn't Mean to Haunt You",2022,"Quadeca",11));
        add(new Album("Digital Footprint Of Doom",2025,"Jayden4627",7));
    }};

    @GetMapping("/json")
    public List<Album> getAlbumsJson() {return albums;}

    @GetMapping("/html")
    public String getAlbumsHtml(){
        String albumList = "<ul>";

        for(Album album : albums){
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;

    }


}



