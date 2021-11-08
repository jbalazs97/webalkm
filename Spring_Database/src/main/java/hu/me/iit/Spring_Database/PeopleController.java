package hu.me.iit.Spring_Database;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public Iterable<PeopleDTO> getAllPeople(){
        List <PeopleDTO> peopleDTOList = new ArrayList<>();
        for (People people:peopleService.getAllPeople()){
            peopleDTOList.add(new PeopleDTO(people));
        }
        return peopleDTOList;
    }

    @PostMapping("/{people}")
    public void save(@RequestBody PeopleCreateDTO model){
        peopleService.addPeople(toPeople(model));
    }

    public PeopleModel toPeople(PeopleCreateDTO peopleCreateDTO){
        return new PeopleModel(null, peopleCreateDTO.getName(), peopleCreateDTO.getAge());
    }
}