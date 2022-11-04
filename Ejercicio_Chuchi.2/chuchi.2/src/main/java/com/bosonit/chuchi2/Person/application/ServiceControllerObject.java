package com.bosonit.chuchi2.Person.application;

import com.bosonit.chuchi2.Person.domain.ControllerObject;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServiceControllerObject {
    public static ControllerObject controllerObject= new ControllerObject();
    public ControllerObject pathQueryHeader(String path, String path2, Map<String,String> query, Map<String,String> headers){
        if(path !=null)
            controllerObject.addPaths(path);
        if(path2 != null )
            controllerObject.addPaths(path2);
        if(query != null)
            controllerObject.addQuerys(query);
        if(headers != null)
            controllerObject.addHeaders(headers);

        return controllerObject;
    }
}
