package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

//        movieStore.getMovies().values().stream()
//                .flatMap(p -> p.)


        System.out.println("\n" + movieStore.getMovies());







    }
}
