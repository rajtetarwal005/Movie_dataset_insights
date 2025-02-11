package model;

public class Actor {
    private int actorId;
    private String name;
    private String dateOfBirth;
    private String nationality;

    public Actor(int actorId, String name, String dateOfBirth, String nationality) {
        this.actorId = actorId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
