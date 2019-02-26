package com.example.kata.pcs;

public class ParentalControlService {

    private final MovieService movieService;

    public ParentalControlService(MovieService movieService) {
        this.movieService = movieService;
    }

    public void canWatchMovie(String preferredLevel, String movieId) {
        try {
            movieService.getParentalControlLevel(movieId);
        } catch (TitleNotFoundException e) {
            e.printStackTrace();
        } catch (TechnicalFailureException e) {
            e.printStackTrace();
        }
    }
}
