package org.seleniumtest.tests;

import org.seleniumtest.funcionaltests.HotelTicket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties extends HotelTicket {



//        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\\\testdata\\\\config");
//
//        Properties proper = new Properties();
//
//
//    public ReadingProperties() throws FileNotFoundException {


    public static FileInputStream file() throws FileNotFoundException {
       return new FileInputStream(System.getProperty("user.dir")+"//testdata//config");
    }


    public void  propertiesObj() throws IOException {
        Properties prop = new Properties();
        prop.load(file());
        String hotel = prop.getProperty("hotelNameOne");
        System.out.println(hotel);
    }


}
