package com.betrybe.museumfinder.exception;

/**
 * Define exceção.
 */
public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException(String message) {
    super(message);
  }
}
