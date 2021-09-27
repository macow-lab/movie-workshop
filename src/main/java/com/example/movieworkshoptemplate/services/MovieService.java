package com.example.movieworkshoptemplate.services;

import ch.qos.logback.core.net.server.Client;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;

public class MovieService {
    //Services called from controllers that returns what the client requests

    MovieDataRepository data = new MovieDataRepository();


    public String getfirst () {
        return data.getFirst();

    }

    public String getRandom () {
        return data.getRandom();

    }

}
