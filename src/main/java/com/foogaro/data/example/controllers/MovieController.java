package com.foogaro.data.example.controllers;

import com.foogaro.data.example.models.Movie;
import com.foogaro.data.example.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

	private final MovieService service;

	public MovieController(MovieService service) {
		this.service = service;
	}

	@GetMapping(value = "/by-title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> byFirstname(@PathVariable("title") String title) {
		List<Movie> data = service.byTitle(title);
		ResponseEntity<List<Movie>> responseEntity = new ResponseEntity<List<Movie>>(data, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(value = "/by-rating/{rating}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> byRating(@PathVariable("rating") long rating) {
		List<Movie> data = service.byRating(rating);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping(value = "/by-year/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> byYear(@PathVariable("year") int year) {
		List<Movie> data = service.byYear(year);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
