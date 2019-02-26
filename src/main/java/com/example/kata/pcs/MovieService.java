package com.example.kata.pcs;

public interface MovieService {
    String getParentalControlLevel(String movieId)
        throws TitleNotFoundException,
        TechnicalFailureException;
}
