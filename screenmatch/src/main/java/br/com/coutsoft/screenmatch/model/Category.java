package br.com.coutsoft.screenmatch.model;

public enum Category {
    ACTION("Action"),
    ROMANCE("Romance"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    CRIME("Crime");

    private String omdbCategory;

    Category(String omdbCategory) {
        this.omdbCategory = omdbCategory;
    }
}
