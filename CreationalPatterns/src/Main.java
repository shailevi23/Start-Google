import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Passenger[] passengers = new Passenger[16];
        Agency agency = new Agency(4,8,3,1);
        for (int i = 0; i < 16; i++) {
            VehicleFactory.VehicleType randomType = VehicleFactory.VehicleType.values()[ThreadLocalRandom.current().nextInt(VehicleFactory.VehicleType.values().length)];
            passengers[i] = new Passenger(Utils.randomString().toString(), randomType);
        }

        for (int i = 0; i < 16; i++) {
            agency.assign(passengers[i]);
        }

        System.out.println(agency.toString());
    }
}