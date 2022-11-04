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
    List<String> paths = new ArrayList<>();
    List<Map> headers = new ArrayList<>();
    List<Map> querys = new ArrayList<>();
    //String urlOrigen;




    public ControllerObject(String path1, String path2, HashMap<String,String> query,HashMap<String,String> header) {
        this.paths.add(path1);
        this.paths.add(path2);
        this.querys.add(query);
        this.headers.add(header);
    }

}
