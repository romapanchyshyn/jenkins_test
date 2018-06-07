package com.epam.lab.data.datdproviderutils;

import com.epam.lab.data.models.UserModel;
import com.epam.lab.data.readers.Reader;

import java.util.List;

public class DataProviderUtiles {

    public static Object[][] provide(String filePath, Reader reader) {
        List<UserModel> userModels = reader.getData(filePath);
        Object[][] objects = new Object[userModels.size()][2];
        for (int i = 0; i < userModels.size(); i++) {
            objects[i][0] = userModels.get(i).getLogin();
            objects[i][1] = userModels.get(i).getPassword();
        }
        return objects;
    }
}
