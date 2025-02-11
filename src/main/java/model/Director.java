package model;

public class Director {
    private int directorId;
    private String name;
    private String dateOfBirth;
    private String nationality;

    public Director(int directorId, String name, String dateOfBirth, String nationality) {
        this.directorId = directorId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorId=" + directorId +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
