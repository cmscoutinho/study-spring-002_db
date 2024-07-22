package br.com.coutsoft.screenmatch.service.translation;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseData(@JsonAlias(value = "translatedText") String translatedText){
}
