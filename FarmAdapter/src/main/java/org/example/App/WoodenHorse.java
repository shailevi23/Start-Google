package org.example.App;

public class WoodenHorse implements WoodenStructures{
    @Override
    public void roll() {
        System.out.println("Rolling...");
    }

    @Override
    public WoodenStructures replicate() {
        return new WoodenHorse();
    }
}
