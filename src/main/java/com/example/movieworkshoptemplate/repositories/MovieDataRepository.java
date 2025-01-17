package com.example.movieworkshoptemplate.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    ArrayList<Movie> tenPicks = new ArrayList<>();

    public void readFile() {
        File f = new File("resources/imdb-data.csv");
        Scanner sc;
        try {
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                if (movieRepository.size() == 0) {
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

    // get first movie
    public String getFirst() {
        Movie m = movieRepository.get(0);
        return m.getTitle();

    }

    // get random list af movies
    public String getRandom() {
        Random random = new Random();
        Movie m = movieRepository.get(random.nextInt(movieRepository.size() - 1));
        return m.getTitle();
    }

    // sort by poopularity
    public ArrayList<String> getTenSortByPopularity() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("TEST");

            Movie m = movieRepository.get(random.nextInt(movieRepository.size() - 1));
            String currentTitle = m.getTitle();
            System.out.println(currentTitle);
            if (tenPicks.contains(m)) {
                while (tenPicks.contains(m)) {
                    m = movieRepository.get(random.nextInt(movieRepository.size() - 1));
                    currentTitle = m.getTitle();
                }
            }
            System.out.println(currentTitle);
            tenPicks.add(m);
        }
        ArrayList<String> result = new ArrayList<>();
        for (Movie movie : sortByPopularity(tenPicks)) {
            result.add(movie.getTitle());
        }
        return result;
    }

    //sort by popularity
    public ArrayList<Movie> sortByPopularity(ArrayList<Movie> movies) {
        ArrayList<Movie> sorted = movies;
        System.out.println("Sorting started");
        Collections.sort(sorted);

        System.out.println(sorted);
        return sorted;

    }

    //Awardcount
    public int countAward() {
        int awardCount = 0;
        for (Movie movie : movieRepository) {
            if (movie.isAwards()) {
                awardCount++;
            }
        }
        return awardCount;
    }

    //Sortering
    public ArrayList<Movie> sortByChar(String x, int n) {
        ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : movieRepository) {
            String titleAsChar = movie.getTitle();

            int integer = 0;
            if (movie.getTitle().contains(x)) {
                char[] ch = new char[titleAsChar.length()];


                for (int i = 0; i < titleAsChar.length(); i++) {
                    ch[i] = titleAsChar.charAt(i);
                }


                for (char c : ch) {

                    if (String.valueOf(c).toLowerCase().equals(x)) {
                        integer++;

                    }

                }
                if (integer == n) {
                    result.add(movie);

                }
            }
        }

        return result;
    }
}
