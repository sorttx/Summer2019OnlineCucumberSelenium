package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // this class will be responsible for loading properties file and will provide access to values based on key names

    //we use this Properties class to load custom .properties files (in this case congigurations.properties)
    private static Properties configFile;


    static{
        try {
            //provide access to file
            //try and catch block handles exceptions
            // if exceptions occurs, code inside a catch block will be executed
            //any class that is related to InputOutput produce checked exceptions
            //without handling exceptions, you cannot run a code

            FileInputStream fileInputStream = new FileInputStream("configuration.properties");

            //initialize properties object
            configFile = new Properties();
            // load your properties file
            configFile.load(fileInputStream);
            //close input stream
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }

    }


    public static String getProperty(String browser) {
        return configFile.getProperty(browser);
    }
}
