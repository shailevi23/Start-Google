package org.example.App;

public class WoodenStructureAdapter implements WoodenStructures{
    Horse horse;

    public WoodenStructureAdapter(Horse horse) {
        this.horse = horse;
    }

    @Override
    public void roll() {
        horse.roll();
    }

    @Override
    public void replicate() {
        horse.replicate();
    }
}
