package com.epam.electricalappliance.device.abstractdevice;

import org.apache.log4j.Logger;

public abstract class Device {

    public static final Logger LOG = Logger.getLogger(Device.class);

    private String id;
    private boolean isOn;
    private int power;
    private int weight;
    private int cost;
    private String brand;

    public Device() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null) {
            this.brand = brand;
        } else {
            LOG.warn("Null Brand is meaningless ");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null) {
            this.id = id;
        } else {
            LOG.warn("Null id is meaningless ");
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost > 0) {
            this.cost = cost;
        } else {
            LOG.warn("Negative cost is meaningless");
        }

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            LOG.warn("Negative weight is meaningless");
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power > 0) {
            this.power = power;
        } else {
            LOG.warn("Negative power is meaningless");
        }
    }
}
