package com.epam.lab.data.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Data")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataModel {
    @XmlElement
    private String lettersNumber;
    @XmlElement
    private String query1;
    @XmlElement
    private String query2;


    public Integer getLettersNumber() {

        return Integer.valueOf(lettersNumber);
    }

    public String getQuery1() {
        return query1;
    }

    public String getQuery2() {
        return query2;
    }

}
