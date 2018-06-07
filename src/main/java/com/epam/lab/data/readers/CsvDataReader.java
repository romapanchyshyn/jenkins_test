package com.epam.lab.data.readers;

import com.epam.lab.data.models.UserModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReader implements Reader {

    public List<UserModel> getData(String filePath){
        List<UserModel> userModels = new ArrayList<>();
        String line = "";
        String cvsSplitter = ",";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            while ((line = reader.readLine()) != null){
                String[] userData = line.split(cvsSplitter);
                userModels.add(new UserModel(userData[0], userData[1]));
            }
            } catch (IOException e1) {
            e1.printStackTrace();
        }
        return userModels;
    }
}
