package nl.teamrockstars.song;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Song {
    @Id
    private Long id;

    @Version
    private Long version;

    @NotNull
    private String name;
    private int year;
    private String artist;
    private String shortName;
    private int bpm;
    private int duration;
    private String genre;
    private String spotifyId;
    private String album;

    protected Song() {
    }

    public Song(final Long id, final String name, final int year,
            final String artist, final String shortName, final int bpm,
            final int duration, final String genre, final String spotifyId,
            final String album) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.artist = artist;
        this.shortName = shortName;
        this.bpm = bpm;
        this.duration = duration;
        this.genre = genre;
        this.spotifyId = spotifyId;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(final String artist) {
        this.artist = artist;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(final int bpm) {
        this.bpm = bpm;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(final String genre) {
        this.genre = genre;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(final String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(final String album) {
        this.album = album;
    }
}
