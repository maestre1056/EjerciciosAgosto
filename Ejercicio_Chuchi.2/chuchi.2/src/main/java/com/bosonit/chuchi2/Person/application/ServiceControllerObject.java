package com.bosonit.chuchi2.Person.application;

import com.bosonit.chuchi2.Person.domain.ControllerObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceControllerObject {
    public static ControllerObject controllerObject= new ControllerObject();
    public ControllerObject returnPath(String path, String path2,String nombre,String ciudad){
        if(path !=null)
            controllerObject.addPaths(path);
        if(path2 != null )
            controllerObject.addPaths(path2);
        if(nombre != null)
            controllerObject.addQuerys("nombre",nombre);
        if(ciudad != null)
            controllerObject.addQuerys("ciudad",ciudad);

        return controllerObject;
    }
}
