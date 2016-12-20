package com.giraffic.locators;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.giraffic.util.FileReader;

public class LocatorReader {

    private Document doc;

    public LocatorReader(final String xmlName) {
        final SAXReader reader = new SAXReader();

        try {
            String localPath = FileReader.getFilePath();
            localPath = localPath + "//src//test//java//com//giraffic//locators//";
            doc = reader.read(localPath+xmlName);
        } catch (final DocumentException e) {
            e.printStackTrace();
        }
    }

    public String getLocator(final String locator) {
        String loc = doc.selectSingleNode("//" + locator.replace('.', '/')).getText();
        loc = loc.trim();
        return loc;
    }
}
