package hu.me.iit.Spring_Database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Iterable<People> getAllPeople() {
        List<People> rv = new ArrayList<>();
        for (PeopleModel people: peopleRepository.findAll()) {
            rv.add(new People(people));
        }
        return rv;
    }

    @Override
    public void addPeople(PeopleModel people) {
        peopleRepository.save(people);
    }


}