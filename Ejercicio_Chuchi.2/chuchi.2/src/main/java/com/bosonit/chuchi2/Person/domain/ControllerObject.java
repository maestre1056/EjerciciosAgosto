package com.bosonit.chuchi2.Person.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ControllerObject {
    List<String> paths;

    //Map<String,String> querys;
    Map<String,String> headers;
    //String urlOrigen;


    public ControllerObject(){
        paths = new ArrayList<>();
        headers = new HashMap<>();
    }

    public  void addPaths(String path){
        paths.add(path);
    }

    //public void addMap(String String)

}
