package com.giraffic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileReader {

    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);
    static String path = getFilePath();
    static String configFile = path + "//src//test//resources//testdata//Config.properties";
    /**
     * It load the configuration file and read data
     * 
     * @param by
     *            String properties file key
     * @return the found value from properties file.
     */
    public static String readData(String key) throws Exception {
        if (StringUtils.isEmpty(key)) {
            throw new Exception("key name is null");
        }

        String value = "";
        try {

            Properties properties = new Properties();
            File file = new File(configFile);
            if (file.exists()) {
                properties.load(new FileInputStream(file));
                value = properties.getProperty(key);
            }
        } catch (Exception e) {
            logger.debug("file not found");
        }
        return value;
    }

    public static String getData(String fileName, String key) throws Exception {
        if (StringUtils.isEmpty(key)) {
            throw new Exception("key name is null");
        }

        String value = "";
        try {

            Properties properties = new Properties();
            File file = new File(fileName);
            if (file.exists()) {
                properties.load(new FileInputStream(file));
                value = properties.getProperty(key);
            }
        } catch (Exception e) {
            logger.debug(fileName + " file not found");
        }
        return value;
    }

    /**
     * It write data in configuration file
     * 
     * @param by
     *            String key
     * @param by
     *            String value
     */
    public void setData(String key, String val) throws Exception {

        if (StringUtils.isEmpty(key))
            throw new Exception("key name is null");
        try {
            File file = new File(configFile);
            Properties properties = new Properties();
            properties.load(new FileInputStream(file));
            FileOutputStream obj = new FileOutputStream(file);
            properties.setProperty(key, val);
            properties.store(obj, "Update data into file ");
            // prop.save(ob, "");

        } catch (IOException ex) {
            logger.debug(" file not found");
        }
    }

    public static String getFilePath() {
        String filepath = "";
        File file = new File("");
        String absolutePathOfFirstFile = file.getAbsolutePath();
        filepath = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
        return filepath;
    }

    public String readTestData_1(String key) {
        String value = "";
        try {
            Properties prop = new Properties();
            File f = new File(path + "//src//test//resources//testdata//TestDataFile.properties");
            System.out.println(f);
            if (f.exists()) {
                prop.load(new FileInputStream(f));
                value = prop.getProperty(key);
            }
        } catch (Exception e) {
            System.out.println("Failed to read from testData.propertiesfile.");
        }
        return value;
    }
}
