package com.epam.electricalappliance.device.kitchen;

import com.epam.electricalappliance.device.abstractdevice.Device;
import org.apache.log4j.Logger;

public class Oven  extends Device {

    public static final Logger LOG = Logger.getLogger(Oven.class);

    public static final int MIN_BAKE_TEMPERATURE = 50;
    public static final int BASIC_BAKE_TEMPERATURE = 250;

    private int ovenTemperature;

    public Oven() {
       LOG.info("Oven has been created");
    }

    public int getOvenTemperature() {
        return ovenTemperature;
    }

    public void setOvenTemperature(int ovenTemperature) {
        if (ovenTemperature > 0) {
            this.ovenTemperature = ovenTemperature;
        } else {
            LOG.warn("Negative ovenTemperature is meaningless");
        }
    }

    public void bake() {
        setOvenTemperature(BASIC_BAKE_TEMPERATURE);
        LOG.info("Oven is ready you can bake");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Oven other = (Oven) obj;
        if (ovenTemperature != other.ovenTemperature) {
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
        result = prime * result + ovenTemperature;
        return result;
    }

    @Override
    public String toString() {
        return "Oven with " + getPower() + " power, status " +  isOn() + " " ;
    }
}
