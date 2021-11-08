package hu.me.iit.Spring_Database;

public interface PeopleService {
    Iterable<People> getAllPeople();
    void addPeople(PeopleModel people);
}