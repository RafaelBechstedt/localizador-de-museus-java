package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Define a camada Service.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  private MuseumFakeDatabase database;

  /**
   * Define método construtor.
   */
  @Autowired
  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.database = museumFakeDatabase;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    Coordinate coordinate = museum.getCoordinate();
    Boolean coordinateValidation = CoordinateUtil.isCoordinateValid(coordinate);
    if (!coordinateValidation) {
      throw new InvalidCoordinateException("Invalid coordinates");
    }
    return database.saveMuseum(museum);
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
