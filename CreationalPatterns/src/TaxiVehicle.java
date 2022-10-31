public class TaxiVehicle implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.toString() + " successful taxi transport");
    }
}
