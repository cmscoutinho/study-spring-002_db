package br.com.coutsoft.screenmatch.model;


import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record SeasonData(@JsonAlias("Title") String title,
                         @JsonAlias("Season") String seasonIdx,
                         @JsonAlias("totalSeasons") String totalSeasons,
                         @JsonAlias("Episodes") List<Episode> episodes) {
}
