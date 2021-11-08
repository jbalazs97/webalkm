package hu.me.iit.Spring_Database;

public class PeopleCreateDTO {

    @NotEmpty
    private String name;
    @Size(min = 18, max = 60)
    private int age;

    public PeopleCreateDTO() {
    }

    public PeopleCreateDTO(People people) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PeopleCreateDTO(PeopleModel people){
        this.name = people.getName();
        this.age = people.getAge();
    }
}