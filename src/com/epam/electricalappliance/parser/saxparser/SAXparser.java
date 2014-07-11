package com.epam.electricalappliance.parser.saxparser;

import com.epam.electricalappliance.exeptions.TechnicalException;
import com.epam.electricalappliance.house.SmartHouse;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXparser {

    private static final Logger LOG = Logger.getLogger(SAXparser.class);

    public SmartHouse parse() throws TechnicalException{

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            LOG.error("Error configuration Parser");
            throw new TechnicalException("Error configuration Parser", e);
        } catch (SAXException e) {
            LOG.error("SAXException exception");
            throw new TechnicalException("SAXException exception", e);
        }

        Handler handler = new Handler();
        try {
            saxParser.parse(new File("resources/electricalappliance.xml"), handler);
        } catch (SAXException e) {
            LOG.error("SAXException exception");
            throw new TechnicalException("SAXException exception", e);
        } catch (IOException e) {
            LOG.error("File not found exception");
            throw new TechnicalException("File not found exception", e);
        }

        return handler.getSmartHouse();

    }


}
