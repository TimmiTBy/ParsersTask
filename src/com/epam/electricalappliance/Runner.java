package com.epam.electricalappliance;

import com.epam.electricalappliance.exeptions.TechnicalException;
import com.epam.electricalappliance.house.SmartHouse;
import com.epam.electricalappliance.parser.StAXparser.StAXparser;
import com.epam.electricalappliance.parser.domparser.DOMParser;
import com.epam.electricalappliance.parser.saxparser.SAXparser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Runner {

    private static final Logger LOG = Logger.getLogger(Runner.class);

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }


    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

/*
        try {
            SmartHouse smartHouse =  new DOMParser().parse();
        } catch (TechnicalException e) {
            e.printStackTrace();
        }


        SmartHouse smartHouse = null;
        try {
            smartHouse = new SAXparser().parse();
        } catch (TechnicalException e) {
            e.printStackTrace();
        }

      */


        StAXparser stAXparser = new StAXparser();
        stAXparser.parse("resources/electricalappliance.xml").showAll();


/*

        try {
            smartHouse.findDeviceByPower(0, 150);
        } catch (LogicException e) {
            e.printStackTrace();
        }

        try {
            new Sort().sort(smartHouse, new DeviceComparatorByCost());
        } catch (LogicException e) {
            e.printStackTrace();
        }

        try {
            new TotalCounter().countTotalCost(smartHouse);
        } catch (LogicException e) {
            e.printStackTrace();
        }*/
    }
}
