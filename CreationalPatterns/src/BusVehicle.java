public class BusVehicle implements Vehicle{


    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.toString() + " successful bus transport");
    }
}
