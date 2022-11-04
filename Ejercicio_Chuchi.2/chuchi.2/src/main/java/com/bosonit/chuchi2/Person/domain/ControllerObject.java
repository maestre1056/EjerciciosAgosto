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
    Map<String,String> headers;
    Map<String,String> querys;
    //String urlOrigen;


    public ControllerObject(){
        paths = new ArrayList<>();
        querys = new HashMap<>();
        headers = new HashMap<>();
    }

    public  void addPaths(String path){
        paths.add(path);
    }

    public void addQuerys(Map query){
        querys.putAll(query);
    }

    public void addHeaders(Map header){
        headers.putAll(header);
    }

}
