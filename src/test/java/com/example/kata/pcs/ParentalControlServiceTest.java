package com.example.kata.pcs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void allows_watching_movie_if_it_is_rated_lower_than_preferred_level() throws Throwable {
        when(movieService.getParentalControlLevel(anyString())).thenReturn("PG");

        boolean allowed = parentalControlService.canWatchMovie("12", "123");

        assertThat(allowed).isTrue();
    }
}
