package com.example.kata.pcs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ParentalControlServiceTest {

    @Mock
    private MovieService movieService;

    private ParentalControlService parentalControlService;

    @Before
    public void setup() {
        parentalControlService = new ParentalControlService(movieService);
    }

    @Test
    public void calls_movie_service_to_retrieve_movie_level() throws Throwable {
        parentalControlService.canWatchMovie("U", "123");

        verify(movieService, atLeastOnce()).getParentalControlLevel("123");
    }
}
