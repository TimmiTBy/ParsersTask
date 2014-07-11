package com.epam.electricalappliance.builder;

import com.epam.electricalappliance.device.bathroom.HairDryer;
import com.epam.electricalappliance.device.kitchen.Fridge;
import com.epam.electricalappliance.device.kitchen.Oven;

public class Director {

    public static Fridge getFridge(String id, boolean isOn, int weight, int cost, int power, int temperature, String brand) {
        FridgeBuilder fridgeBuilder = new FridgeBuilder();
        fridgeBuilder.buildId(id);
        fridgeBuilder.buildTemperature(temperature);
        fridgeBuilder.buildIsOn(isOn);
        fridgeBuilder.buildWeight(weight);
        fridgeBuilder.buildCost(cost);
        fridgeBuilder.buildPower(power);
        fridgeBuilder.buildBrand(brand);
        return fridgeBuilder.getDevice();
    }

    public static Oven getOven(String id, boolean isOn, int weight, int cost, int power, int temperature, String brand) {
        OvenBuilder ovenBuilder = new OvenBuilder();
        ovenBuilder.buildBrand(brand);
        ovenBuilder.buildTemperature(temperature);
        ovenBuilder.buildId(id);
        ovenBuilder.buildIsOn(isOn);
        ovenBuilder.buildWeight(weight);
        ovenBuilder.buildCost(cost);
        ovenBuilder.buildPower(power);
        return ovenBuilder.getDevice();
    }

    public static HairDryer getHairDryer(String id, boolean isOn, int weight, int cost, int power, int windSpeed, String brand) {
        HairDryerBuilder hairDryerBuilder = new HairDryerBuilder();
        hairDryerBuilder.buildId(id);
        hairDryerBuilder.buildIsOn(isOn);
        hairDryerBuilder.buildWeight(weight);
        hairDryerBuilder.buildCost(cost);
        hairDryerBuilder.buildPower(power);
        hairDryerBuilder.buildWindSpeed(windSpeed);
        hairDryerBuilder.buildBrand(brand);

        return hairDryerBuilder.getDevice();
    }
}
