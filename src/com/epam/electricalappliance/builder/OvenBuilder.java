package com.epam.electricalappliance.builder;


import com.epam.electricalappliance.device.kitchen.Oven;

public class OvenBuilder extends Builder {

    Oven oven = new Oven();

    public void buildBrand(String brand) {
        oven.setBrand(brand);
    }

    public void buildTemperature(int temperature) {
        oven.setOvenTemperature(temperature);
    }

    public void buildId(String id) {
        oven.setId(id);
    }

    public void buildPower(int power) {
        oven.setPower(power);
    }

    public void buildCost(int cost) {
        oven.setCost(cost);
    }

    public void buildWeight(int weight) {
        oven.setWeight(weight);
    }

    public void buildIsOn(boolean isOn) {
        oven.setOn(isOn);
    }

    @Override
    public Oven getDevice() {
        return oven;
    }
}
