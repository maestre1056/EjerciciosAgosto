package com.bosonit.chuchi2.Person.infraestructure;

import com.bosonit.chuchi2.Person.application.ServiceControllerObject;
import com.bosonit.chuchi2.Person.domain.ControllerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    ServiceControllerObject serviceController;

    @GetMapping(value = {"*","{path}","{path}/{path2}"})
    public ControllerObject paths(@PathVariable (required = false) String path,
                                  @PathVariable (required = false)  String path2,
                                  @RequestParam (required = false) String nombre,
                                  @RequestParam (required = false) String ciudad){
        return serviceController.returnPath(path,path2,nombre,ciudad);
    }

    @GetMapping(value = {"","/one"})
    public String entryone(){
        return "Has entrado en entryone";
    }
}
