package com.example.movieworkshoptemplate.repositories;

import java.util.ArrayList;
import com.example.movieworkshoptemplate.models.Movie;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class MovieDataRepository {
    // Methods to get data from file

    public MovieDataRepository() {
        readFile();
        System.out.println(movieRepository.size());
    }

    ArrayList<Movie> movieRepository = new ArrayList<>();

    public void readFile() {
        File f = new File("resources/imdb-data.csv");
        Scanner sc;
        try {
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                if(movieRepository.size() == 0) {
                    sc.nextLine();
                }
                String line = sc.nextLine();
                String[] values = line.split(";");
                movieRepository.add(new Movie(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2], values[3], Integer.parseInt(values[4]), values[5]));
            }
        } catch (Exception e) {
            System.out.println("Error while reading file");
        }
        System.out.println("File reading complete!");
    }

    public String getFirst() {
        Movie m  = movieRepository.get(0);
        return m.getTitle();

    }
    public String getRandom() {
        Random random = new Random();
        Movie m  = movieRepository.get(random.nextInt(movieRepository.size() -  1));
        return m.getTitle();
    }

    public ArrayList<String> getTenSortByPopularity() {
        ArrayList<Movie> localHolder = new ArrayList<Movie>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("TEST");

            Movie m  = movieRepository.get(random.nextInt(movieRepository.size() -  1));
            String currentTitle = m.getTitle();
            System.out.println(currentTitle);
            if (localHolder.contains(m.getTitle())) {
                while (localHolder.contains(currentTitle)) {
                    m  = movieRepository.get(random.nextInt(movieRepository.size() -  1));
                    currentTitle = m.getTitle();
                }
            } 
            System.out.println(currentTitle);
            localHolder.add(m);
        }
        System.out.println(localHolder);
        return sortByPopularity(localHolder);
    }

    public ArrayList<String> sortByPopularity(ArrayList<Movie> movies) {
        ArrayList<String> result = new ArrayList<String>();


        return result;

    }
}
