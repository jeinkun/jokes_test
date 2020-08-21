package com.olga.jokes;

import java.util.List;

public class Joke {
    private String type;
    private List<Values> value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Values> getJoke(){
        return value;
    }

    public void setJoke(List<Values> joke){
        this.value = joke;
    }
}

class Values {
    private int id;
    private String joke;

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke){
        this.joke = joke;
    }
}