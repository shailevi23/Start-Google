public class BoatVehicle implements Vehicle{

    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.toString() + " successful boat transport");
    }
}
