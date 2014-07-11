package com.epam.electricalappliance.parser.StAXparser;

import com.epam.electricalappliance.device.abstractdevice.Device;
import com.epam.electricalappliance.device.bathroom.HairDryer;
import com.epam.electricalappliance.device.kitchen.Fridge;
import com.epam.electricalappliance.device.kitchen.Oven;
import com.epam.electricalappliance.house.SmartHouse;
import com.epam.electricalappliance.parser.TagsElements;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class StAXparser {

    private static final Logger LOG = Logger.getLogger(StAXparser.class);


    private XMLStreamReader reader;
    private SmartHouse smartHouse;
    private Device currentDevice;
    private String tagContent;


    public StAXparser() {
        smartHouse = new SmartHouse();
    }

    public SmartHouse parse(String XMLpath) throws FileNotFoundException {

        InputStream in = new FileInputStream(new File(XMLpath));
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            reader = inputFactory.createXMLStreamReader(in);


        } catch (XMLStreamException e) {
            LOG.error("XML StreamReader error");
        }

        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {

                    case XMLStreamConstants.START_ELEMENT:
                        switch (reader.getLocalName()) {
                            case TagsElements.HAIRDRYER:
                                currentDevice = new HairDryer();
                                currentDevice.setId(reader.getAttributeValue(0));
                                currentDevice.setBrand(reader.getAttributeValue(1));
                                break;
                            case TagsElements.FRIDGE:
                                currentDevice = new Fridge();
                                currentDevice.setId(reader.getAttributeValue(0));
                                currentDevice.setBrand(reader.getAttributeValue(1));
                                break;
                            case TagsElements.OVEN:
                                currentDevice = new Oven();
                                currentDevice.setId(reader.getAttributeValue(0));
                                currentDevice.setBrand(reader.getAttributeValue(1));
                                break;
                            default:
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case TagsElements.HAIRDRYER:
                                smartHouse.addDevice(currentDevice);
                                break;
                            case TagsElements.FRIDGE:
                                smartHouse.addDevice(currentDevice);
                                break;
                            case TagsElements.OVEN:
                                smartHouse.addDevice(currentDevice);
                                break;
                            case TagsElements.IS_ON:
                                currentDevice.setOn(Boolean.valueOf(tagContent));
                                break;
                            case TagsElements.POWER:
                                currentDevice.setPower(Integer.valueOf(tagContent));
                                break;
                            case TagsElements.WEIGHT:
                                currentDevice.setWeight(Integer.valueOf(tagContent));
                                break;
                            case TagsElements.COST:
                                currentDevice.setCost(Integer.valueOf(tagContent));
                                break;
                            case  TagsElements.WIND_SPEED:
                                ((HairDryer)currentDevice).setWindSpeed(Integer.valueOf(tagContent));
                                break;
                            case  TagsElements.FRIDGE_TEMPERATURE:
                                ((Fridge)currentDevice).setFridgeTemperature(Integer.valueOf(tagContent));
                                break;
                            case  TagsElements.OVEN_TEMPERATURE:
                                ((Oven)currentDevice).setOvenTemperature(Integer.valueOf(tagContent));
                                break;
                        }
                        break;


                }

            }
        } catch (XMLStreamException e) {
            LOG.error("Stream Error!");
        }

    return smartHouse;
    }

}
