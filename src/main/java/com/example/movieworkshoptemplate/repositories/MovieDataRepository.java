package com.example.movieworkshoptemplate.repositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import com.example.movieworkshoptemplate.models.Movie;
import java.util.Random;

public class MovieDataRepository {
    // Methods to get data from file

    public MovieDataRepository() {
        readFile();
    }

    ArrayList<Movie> movieRepository = new ArrayList<>();

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/imdb-data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                movieRepository.add(new Movie(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2], values[3], Integer.parseInt(values[4]), values[5]));
            }
        } catch (Exception e) {
            System.out.println("Error while reading file");
        }
    }

    public String getFirst() {
        Movie m  = movieRepository.get(0);
        return m.getTitle();

    }
    public String getRandom() {
        Random random = new Random ();
        Movie m  = movieRepository.get(random.nextInt(movieRepository.size()));
        return m.getTitle();
    }
}
