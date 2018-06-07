package com.epam.lab.data.readers;

import com.epam.lab.data.models.DataModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DataReader {
    public DataModel readData(File xml) {
        DataModel data = new DataModel();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataModel.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            data = (DataModel) unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return data;
    }
}
