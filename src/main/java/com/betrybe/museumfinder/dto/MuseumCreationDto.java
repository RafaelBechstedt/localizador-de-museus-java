package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Define dto Museum sem ID e legacyID.
 */
public record MuseumCreationDto(String name, String description, String address,
                                String collectionType, String subject, String url, Coordinate coordinate) {

}
