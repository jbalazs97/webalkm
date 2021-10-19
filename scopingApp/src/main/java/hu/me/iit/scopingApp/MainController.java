package hu.me.iit.scopingApp;

import java.security.Provider.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final Service service;

    public MainController(Service service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/a")
    public String getRoot(){
        return  service.getValue();
    }
}