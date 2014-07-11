package com.epam.electricalappliance.parser.saxparser;

import com.epam.electricalappliance.device.abstractdevice.Device;
import com.epam.electricalappliance.device.bathroom.HairDryer;
import com.epam.electricalappliance.device.kitchen.Fridge;
import com.epam.electricalappliance.device.kitchen.Oven;
import com.epam.electricalappliance.house.SmartHouse;
import com.epam.electricalappliance.parser.TagsElements;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
    private static final Logger LOG = Logger.getLogger(SmartHouse.class);

    private SmartHouse smartHouse;
    private Device currentDevice;
    private String element;

    public Handler() {
        smartHouse = new SmartHouse();
    }

    public SmartHouse getSmartHouse() {
        return smartHouse;
    }


    @Override
    public void startDocument() throws SAXException {
        LOG.info("Parsing with SAX parser started");
    }

    @Override
    public void endDocument() throws SAXException {
        LOG.info("Parsing with SAX parser finished");
    }

    @Override
    public void startElement(String nameSpace, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case TagsElements.HAIRDRYER:
                currentDevice = new Fridge();
                currentDevice.setId(attributes.getValue(0));
                currentDevice.setBrand(attributes.getValue(1));
                break;
            case TagsElements.FRIDGE:
                currentDevice = new Fridge();
                currentDevice.setId(attributes.getValue(0));
                currentDevice.setBrand(attributes.getValue(1));
                break;
            case TagsElements.OVEN:
                currentDevice = new Fridge();
                currentDevice.setId(attributes.getValue(0));
                currentDevice.setBrand(attributes.getValue(1));
                break;
            default:
                element = qName;
        }
    }

    @Override
    public void endElement(String nameSpace, String localName, String qName) throws SAXException {
        switch (qName) {
            case TagsElements.HAIRDRYER:
                smartHouse.addDevice(currentDevice);
                LOG.info(currentDevice + "added to smartHouse");
                break;
            case TagsElements.FRIDGE:
                smartHouse.addDevice(currentDevice);
                LOG.info(currentDevice + "added to smartHouse");
                break;
            case TagsElements.OVEN:
                smartHouse.addDevice(currentDevice);
                LOG.info(currentDevice + "added to smartHouse");
            default:
                element = qName;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)  throws SAXException {

        String value = new String(ch, start, length).trim();

            switch (element) {
                case TagsElements.IS_ON:
                    currentDevice.setOn(Boolean.valueOf(value));
                    break;
                case TagsElements.POWER:
                    currentDevice.setPower(Integer.valueOf(value));
                    break;
                case TagsElements.WEIGHT:
                    currentDevice.setWeight(Integer.valueOf(value));
                    break;
                case TagsElements.COST:
                    currentDevice.setCost(Integer.valueOf(value));
                    break;
                case TagsElements.WIND_SPEED:
                    ((HairDryer) currentDevice).setWindSpeed(Integer.valueOf(value));
                    break;
                case TagsElements.FRIDGE_TEMPERATURE:
                    ((Fridge) currentDevice).setFridgeTemperature(Integer.valueOf(value));
                    break;
                case TagsElements.OVEN_TEMPERATURE:
                    ((Oven) currentDevice).setOvenTemperature(Integer.valueOf(value));
                    break;
                default:

            }

        }

}
