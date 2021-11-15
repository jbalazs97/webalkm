package hu.me.iit.Spring_Database;

public interface PeopleService {
    Iterable<People> getAllPeople();

    People create(People toPeople);

    void deleteById(Long id);

    People getById(Long id);

    void save(People people);
}