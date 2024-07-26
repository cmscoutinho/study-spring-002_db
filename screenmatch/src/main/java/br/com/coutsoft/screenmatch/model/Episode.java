package br.com.coutsoft.screenmatch.model;

import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer episodeIdx;
    private Double rating;
    private LocalDate releaseDate;
    @ManyToOne
    private Series series;

    public Episode(Integer season, EpisodeData episodeData) {
        this.season = season;
        this.title = episodeData.title();
        this.episodeIdx = episodeData.episodeIdx();

        try {
            this.rating = Double.valueOf(episodeData.rating());
        } catch (NumberFormatException ex) {
            this.rating = 0.0;
        }

        try {
            this.releaseDate = LocalDate.parse(episodeData.releaseDate());
        } catch (DateTimeParseException ex) {
            this.releaseDate = null;
        }
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeIdx() {
        return episodeIdx;
    }

    public void setEpisodeIdx(Integer episodeIdx) {
        this.episodeIdx = episodeIdx;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "temporada=" + season +
                ", titulo='" + title + '\'' +
                ", numeroEpisodio=" + episodeIdx +
                ", avaliacao=" + rating +
                ", dataLancamento=" + releaseDate;
    }
}

