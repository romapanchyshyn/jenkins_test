package com.epam.lab.data.readers;

import com.epam.lab.data.models.UserModel;

import java.util.List;

public interface Reader {
    List<UserModel> getData(String filePath);
}
