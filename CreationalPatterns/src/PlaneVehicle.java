public class PlaneVehicle implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.toString() + " successful plane transport");
    }
}
