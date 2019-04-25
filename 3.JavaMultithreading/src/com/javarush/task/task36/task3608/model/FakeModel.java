package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;

public class FakeModel implements Model{

    private ModelData modelData = new ModelData();

    @Override
    public void loadUsers() {

        modelData.getUsers().add(new User("name1", 1, 1));
        modelData.getUsers().add(new User("name2", 2, 1));
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }
}
