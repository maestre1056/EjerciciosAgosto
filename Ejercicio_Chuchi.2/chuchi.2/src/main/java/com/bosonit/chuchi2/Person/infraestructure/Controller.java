package com.bosonit.chuchi2.Person.infraestructure;
import com.bosonit.chuchi2.Person.domain.ControllerObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;


@RestController
public class Controller {


    @GetMapping(value = {"*","{path}","{path}/{path2}"})
    public Object paths(@PathVariable (required = false) String path,
                        @PathVariable (required = false)  String path2,
                        @RequestParam (required = false) HashMap<String,String> query,
                        @RequestHeader (required = false) HashMap<String,String> headers)
                                  {
            if(headers.containsKey("redirige") && headers.containsValue("salta")){
                return new ModelAndView("redirect:/hola");
            }

        return new ControllerObject(path,path2,query,headers);
    }

    @GetMapping(value = {"","/one"})
    public String entryone(){
        return "Has entrado en entryone";
    }

    @GetMapping(value = {"/hola"})
    public String salta(){
        return "Estamos en Salta";
    }
}
