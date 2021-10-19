package hu.me.iit.webalkm.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {

	private Service service;
	
	@Autowired
    @Qualifier("NeededService")
    public void setService(Service service){
        this.service = service;
    }

    @RequestMapping("/")
    public int returnFive(){
        return service.returnFive();
    }
}
