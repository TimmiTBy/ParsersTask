package com.epam.electricalappliance.builder;

import com.epam.electricalappliance.device.kitchen.Fridge;

public class FridgeBuilder extends Builder {

    private Fridge fridge = new Fridge();

    public void buildBrand(String brand) {
        fridge.setBrand(brand);
    }

    public void buildTemperature(int temperature) {
        fridge.setFridgeTemperature(temperature);
    }

    public void buildId(String id) {
        fridge.setId(id);
    }

    public void buildPower(int power) {
        fridge.setPower(power);
    }

    public void buildCost(int cost) {
        fridge.setCost(cost);
    }

    public void buildWeight(int weight) {
        fridge.setWeight(weight);
    }

    public void buildIsOn(boolean isOn) {
        fridge.setOn(isOn);
    }

    @Override
    public Fridge getDevice() {
        return fridge;
    }
}
