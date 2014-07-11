package com.epam.electricalappliance.builder;


import com.epam.electricalappliance.device.bathroom.HairDryer;


public class HairDryerBuilder extends Builder{

    HairDryer hairDryer = new HairDryer();

    public void buildBrand(String brand) {
        hairDryer.setBrand(brand);
    }


    public void buildId(String id) {
        hairDryer.setId(id);
    }

    public void buildPower(int power) {
        hairDryer.setPower(power);
    }

    public void buildCost(int cost) {
        hairDryer.setCost(cost);
    }

    public void buildWeight(int weight) {
        hairDryer.setWeight(weight);
    }

    public void buildIsOn(boolean isOn) {
        hairDryer.setOn(isOn);
    }

    public void buildWindSpeed(int windSpeed) {
        hairDryer.setWindSpeed(windSpeed);
    }

    @Override
    public HairDryer getDevice() {
        return hairDryer;
    }
}
