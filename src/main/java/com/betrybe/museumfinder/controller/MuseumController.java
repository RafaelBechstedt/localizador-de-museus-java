package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Define a camada Controller.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {

  private final MuseumServiceInterface museumService;

  /**
   * Define construtor.
   */
  @Autowired
  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumService = museumServiceInterface;
  }

  /**
   * Cria rota post.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MuseumDto createMuseum(@RequestBody MuseumCreationDto newMuseum) {
    Museum museumConverted = ModelDtoConverter.dtoToModel(newMuseum);
    Museum museumCreated = museumService.createMuseum(museumConverted);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(museumCreated);
    return museumDto;
  }

  /**
   * Cria rota get.
   */
  @GetMapping("/closest")
  @ResponseStatus(HttpStatus.OK)
  public MuseumDto getClosestMuseum(
      @RequestParam("lat") Double latitude,
      @RequestParam("lng") Double longitude,
      @RequestParam("max_dist_km") Double maxDistance) {
    Coordinate coordinate = new Coordinate(latitude, longitude);
    Museum closestMuseum = museumService.getClosestMuseum(coordinate, maxDistance);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(closestMuseum);
    return museumDto;
  }
}
