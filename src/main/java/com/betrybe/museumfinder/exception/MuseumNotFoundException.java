package com.betrybe.museumfinder.exception;

/**
 * Define exceção.
 */
public class MuseumNotFoundException extends RuntimeException {

  public MuseumNotFoundException(String message) {
    super(message);
  }
}
