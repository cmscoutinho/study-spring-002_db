package br.com.coutsoft.screenmatch.model;


import java.util.List;

public record SeasonData(String title,
                         String seasonIdx,
                         String totalSeasons,
                         List<Episode> episodes) {
}
