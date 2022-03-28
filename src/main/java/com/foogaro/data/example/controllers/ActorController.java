package com.foogaro.data.example.controllers;

import com.foogaro.data.example.models.Actor;
import com.foogaro.data.example.services.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/actors")
public class ActorController {

	private final ActorService service;

	public ActorController(ActorService service) {
		this.service = service;
	}

	@GetMapping(value = "/by-firstname/{firstname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Actor>> byFirstname(@PathVariable("firstname") String firstname) {
		List<Actor> data = service.byFirstname(firstname);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping(value = "/by-lastname/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Actor>> byLastname(@PathVariable("lastname") String lastname) {
		List<Actor> data = service.byLastname(lastname);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping(value = "/by-yearOfBirth/{yearOfBirth}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Actor>> byFirstname(@PathVariable("yearOfBirth") Integer yearOfBirth) {
		List<Actor> data = service.byYearOfBirth(yearOfBirth);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
