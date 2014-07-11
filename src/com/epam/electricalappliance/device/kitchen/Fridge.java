package com.epam.electricalappliance.device.kitchen;
import com.epam.electricalappliance.device.abstractdevice.Device;
import org.apache.log4j.Logger;

public class Fridge  extends Device {

    public static final Logger LOG = Logger.getLogger(Fridge.class);

    public static final int MAX_FRIDGE_TEMPERATURE = 15;
    public static final int FREEZ_TEMPERATURE = -15;
    public static final int NORMAL_TEMPERATURE = 7;

    private int fridgeTemperature;

    public Fridge() {
       LOG.info("Fridge has been created");
    }

    public int getFridgeTemperature() {
        return fridgeTemperature;
    }

    public void setFridgeTemperature(int fridgeTemperature) {
        if (fridgeTemperature > 0) {
            this.fridgeTemperature = fridgeTemperature;
        } else {
            LOG.warn("Negative fridgeTemperature is meaningless");
        }
    }

    public void freezMode() {
        setFridgeTemperature(FREEZ_TEMPERATURE);
        LOG.info("Fridge can freez everthing!");
    }

    public void normalMode() { 
        setFridgeTemperature(NORMAL_TEMPERATURE);
        LOG.info("Fridge in a normal mode");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fridge other = (Fridge) obj;
        if (fridgeTemperature != other.fridgeTemperature) {
            return false;
        }
        if(this.getPower() != other.getPower()) {
            return false;
        }
        if(this.getCost() != other.getCost()) {
            return false;
        }
        if(this.getWeight() != other.getWeight()) {
            return false;
        }
        if(this.isOn() != other.isOn()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fridgeTemperature;
        return result;
    }

    @Override
    public String toString() {
        return "Fridge with " + getPower() + " power, status " +  isOn() + " " ;
    }
}
