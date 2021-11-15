package hu.me.iit.Spring_Database;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public Iterable<PeopleDto> getAllPeople() {
        List<PeopleDto> peopleDtoList = new ArrayList<>();
        for(People people :  peopleService.getAllPeople()){
            peopleDtoList.add(new PeopleDto(people));
        }

        return peopleDtoList;
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public PeopleDto save(@RequestBody @Valid PeopleDto peopleCreateDto){
        return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        peopleService.deleteById(id);
    }

    @GetMapping("/{id}")
    public PeopleDto getById(@PathVariable("id") Long id){
        return new PeopleDto(peopleService.getById(id));
    }

    @PutMapping
    public void updatePeople(@RequestBody @Valid PeopleDto peopleDto){
        peopleService.save(peopleDto.toEntity());
    }
}

