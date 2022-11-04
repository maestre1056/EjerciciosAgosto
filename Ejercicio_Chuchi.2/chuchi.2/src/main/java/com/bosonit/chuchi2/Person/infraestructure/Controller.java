package com.bosonit.chuchi2.Person.infraestructure;

import com.bosonit.chuchi2.Person.application.ServiceControllerObject;
import com.bosonit.chuchi2.Person.domain.ControllerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller {
    @Autowired
    ServiceControllerObject serviceController;

    @GetMapping(value = {"*","{path}","{path}/{path2}"})
    public ControllerObject paths(@PathVariable (required = false) String path,
                                  @PathVariable (required = false)  String path2,
                                  @RequestParam (required = false) Map<String,String> query,
                                  @RequestHeader (required = false) Map<String,String> headers)
                                  {
        return serviceController.pathQueryHeader(path,path2,query,headers);
    }

    @GetMapping(value = {"","/one"})
    public String entryone(){
        return "Has entrado en entryone";
    }
}
