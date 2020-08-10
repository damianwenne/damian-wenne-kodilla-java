package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

        String listOfMovies = movieStore.getMovies().values().stream()
                .flatMap(p -> p.stream())
                .collect(Collectors.joining(" ! "));

        System.out.println(listOfMovies);

    }
}
