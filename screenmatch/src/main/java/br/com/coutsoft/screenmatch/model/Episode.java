package br.com.coutsoft.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Episode(@JsonAlias("Episode") String episodeIdx,
                      @JsonAlias("Title") String title,
                      @JsonAlias("Released") String releaseDate,
                      @JsonAlias("imdbRating") String rating) {
}
