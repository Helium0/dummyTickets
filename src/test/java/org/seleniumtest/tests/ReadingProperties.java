package org.seleniumtest.tests;

import org.seleniumtest.funcionaltests.HotelTicket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadingProperties extends HotelTicket {



    private     FileInputStream fileInputStream() throws FileNotFoundException {
                FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\dataVariables");
                return file;
        }


        public String getValues(String value) throws IOException {
               Properties prop = new Properties();
               prop.load(fileInputStream());
               String vvv = prop.getProperty(value);
               return vvv;
        }

}



