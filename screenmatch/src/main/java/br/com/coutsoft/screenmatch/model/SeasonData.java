package br.com.coutsoft.screenmatch.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonData(@JsonAlias("Title") String title,
                         @JsonAlias("Season") String seasonIdx,
                         @JsonAlias("totalSeasons") String totalSeasons,
                         @JsonAlias("Episodes") List<EpisodeData> episodeData) {
}
