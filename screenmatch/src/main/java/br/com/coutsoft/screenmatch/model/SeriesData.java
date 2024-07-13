package br.com.coutsoft.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(@JsonAlias("Title") String title,
                         @JsonAlias("imdbRating") String rating,
                         @JsonAlias("totalSeasons") String seasons,
                         @JsonAlias("Released") String releaseDate){}
