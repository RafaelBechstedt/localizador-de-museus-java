package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Define ControllerAdvice.
 */
@ControllerAdvice
public class ControllerAdviceHandler {

  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinateException(InvalidCoordinateException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenada inválida!");
  }

  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> handleMuseumNotFoundException(MuseumNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Museu não encontrado!");
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGenericException(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno!");
  }
}