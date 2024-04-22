package com.scytalys.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.scytalys.model.Customer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class XmlParser {
    public static void main(String[] args) {

        String xmlDoc = """
                <guests>      
                  <guest>        
                    <firstName>John</firstName>
                    <lastName>Doe</lastName>    
                  </guest> 
                  <guest>
                    <firstName>María</firstName>
                    <lastName>García</lastName> 
                  </guest> 
                  <guest>     
                    <firstName>Nikki</firstName> 
                    <lastName>Wolf</lastName>
                  </guest>      
                </guests>
                """;

        Customer[] guests = null;


//        DESERIALIZATION OF XML TO OBJECT

        XmlMapper xmlMapper = new XmlMapper();
        try {
            guests = xmlMapper.readValue(xmlDoc, Customer[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Arrays.stream(guests).forEach(System.out::println);


//        SERIALIZATION OF OBJECT TO XML

        try {
            xmlMapper.writeValue(
                    new File("data/guests.xml"),
                    guests);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(
                    new File("data/guests.json"),
                    guests);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
