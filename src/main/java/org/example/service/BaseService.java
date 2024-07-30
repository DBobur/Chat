package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.BaseModel;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public abstract class BaseService<T extends BaseModel> {
    protected String PATH = "/Users/khurshideshonkulov/IdeaProjects/Chat/src/main/resources";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public boolean addModel(T t){
        if(hasModel(t)) return false;
        ArrayList<T> ts = readAll();
        ts.add(t);
        writeAll(ts);
        return true;
    }

    public T getById(UUID id){
        ArrayList<T> ts = readAll();
        for (T t : ts) {
            if(Objects.equals(t.getId(),id)) return t;
        }
        return null;
    }

    // database methods
    protected void writeAll(ArrayList<T> ts){
        try (FileWriter writer = new FileWriter(PATH)){
            String json = gson.toJson(ts);
            writer.write(json);
        }catch (IOException e){}
    }

    protected ArrayList<T> readAll(){
        try(FileReader reader = new FileReader(PATH)){
            Type type = TypeToken.getParameterized(ArrayList.class,getType()).getType();
            return gson.fromJson(reader,type);
        }catch (IOException e){
            return new ArrayList<>();
        }
    }

    protected abstract boolean hasModel(T t);

    protected abstract Class<T> getType();
}
