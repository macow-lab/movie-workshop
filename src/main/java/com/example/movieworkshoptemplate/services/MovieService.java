package com.example.movieworkshoptemplate.services;

import ch.qos.logback.core.net.server.Client;
import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;
import java.util.ArrayList;

public class MovieService {
    //Services called from controllers that returns what the client requests
    MovieDataRepository data = new MovieDataRepository();

    //1
    public String getfirst() {
        return data.getFirst();
    }

    //2
    public String getRandom() {
        return data.getRandom();
    }

    //3
    public ArrayList<String> getTenSortByPopularity() {
        return data.getTenSortByPopularity();
    }

    //4
    public int countAward() {
        return data.countAward();
    }

    //5
    public ArrayList<Movie> sortByChar(String x, int parseInt) {
        return data.sortByChar(x, parseInt);

    }

}


