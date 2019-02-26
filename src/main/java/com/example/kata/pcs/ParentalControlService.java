package com.example.kata.pcs;

public class ParentalControlService {

    private static final String[] LEVELS = {"U", "PG", "12", "15", "18"};

    private final MovieService movieService;

    public ParentalControlService(MovieService movieService) {
        this.movieService = movieService;
    }

    private static int findIndex(String level) {
        for (int i = 0; i < LEVELS.length; i++) {
            if (level != null && LEVELS[i].contentEquals(level)) {
                return i;
            }
        }
        return -1;
    }

    public boolean canWatchMovie(String preferredLevel, String movieId) throws TitleNotFoundException {
        try {
            String movieLevel = movieService.getParentalControlLevel(movieId);
            return findIndex(preferredLevel) >= findIndex(movieLevel);
        } catch (TechnicalFailureException e) {
            e.printStackTrace();
        }
        return true;
    }
}
