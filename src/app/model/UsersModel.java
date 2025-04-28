package app.model;

public class UsersModel {

    private int id;
    private String name;
    private String lastName;
    private int age;
    private String nationality;

    public UsersModel(int id, String name, String lastName, int age, String nationality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }

    public UsersModel() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    
    @Override
    public String toString() {
        return "UsersModel [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", nationality="
                + nationality + "]";
    }
}
