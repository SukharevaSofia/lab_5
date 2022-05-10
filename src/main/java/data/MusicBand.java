package data;
/**
 * Класс MusicBand
 */

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class MusicBand {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    public static Integer counter = 0;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Timestamp creationDate;
    private Integer numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private Integer albumsCount; //Поле может быть null, Значение поля должно быть больше 0
    private String description; //Поле может быть null
    private MusicGenre genre; //Поле может быть null
    private BestAlbum bestAlbum; //Поле не может быть null

    public MusicBand (String name, Coordinates coordinates,Integer numberOfParticipants, Integer albumsCount,
                      String description, MusicGenre genre, BestAlbum bestAlbum){
        id = counter++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.numberOfParticipants = numberOfParticipants;
        this.albumsCount = albumsCount;
        this.description = description;
        this.genre = genre;
        this.bestAlbum = bestAlbum;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCounter(){return counter;}

    public void setCounter(Integer counter){MusicBand.counter = counter;}

    public String getName() {
        return name;
    }

    public void setName(String name){this.name = name;}

    public Coordinates getCoordinates(){return coordinates;}

    public void setCoordinates(Coordinates coordinates){this.coordinates = coordinates;}

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(Integer numberOfParticipants){this.numberOfParticipants = numberOfParticipants;}

    public Integer getAlbumsCount() { return albumsCount;}

    public void setAlbumsCount(Integer albumsCount) { this.albumsCount = albumsCount;}

    public String getDescription() { return description;}

    public void setDescription(String description) { this.description = description;}

    public MusicGenre getGenre() {return genre;}

    public void setGenre(MusicGenre genre) { this.genre = genre;}

    public BestAlbum getBestAlbum(){return bestAlbum;}

    public void setBestAlbum(BestAlbum bestAlbum) { this.bestAlbum = bestAlbum;}

    @Override
    public String toString(){
        return "ID: " + getId() +
                "\nName: " + getName() +
                "\nCoordinates: " + coordinates.toString() +
                "\nCreation date: " + creationDate.toString() +
                "\nNumber of participants: " + getNumberOfParticipants() +
                "\nAlbums count: " + getAlbumsCount() +
                "\nDescription: " + getDescription() +
                "\nGenre: " + getGenre() +
                "\nBest album: " + bestAlbum.toString();
    }
}
