import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Agency {

    private int numOfBuses;
    private int numOfTaxis;
    private int numOfPlanes;
    private int numOfBoats;


    private ArrayList<Vehicle> vehicles;
    private Map<Passenger, Vehicle> mapPassengerVehicle;

    public Agency(int numOfBuses, int numOfTaxis, int numOfBoats, int numOfPlanes) {
        this.vehicles = new ArrayList<>();
        this.mapPassengerVehicle = new HashMap<>();

        this.numOfBuses = numOfBuses;
        addVehicle(numOfBuses, VehicleFactory.VehicleType.BUS);
        this.numOfTaxis = numOfTaxis;
        addVehicle(numOfTaxis, VehicleFactory.VehicleType.TAXI);
        this.numOfBoats = numOfBoats;
        addVehicle(numOfBoats, VehicleFactory.VehicleType.BOAT);
        this.numOfPlanes = numOfPlanes;
        addVehicle(numOfPlanes, VehicleFactory.VehicleType.PLANE);
    }

    public void addVehicle(int numOfVehicle, VehicleFactory.VehicleType vehicleType){
        VehicleFactory factory = VehicleFactory.getInstance();
        for (int i = 0; i < numOfVehicle; i++) {
            vehicles.add(factory.createVehicle(vehicleType));
        }
    }

    public void assign(Passenger passenger){
        Vehicle vehicle = pickVehicleForPassenger(passenger.getVehicleType());
        this.mapPassengerVehicle.put(passenger,vehicle);
        this.vehicles.remove(vehicle);
    }

    public Vehicle pickVehicleForPassenger(VehicleFactory.VehicleType vehicleType){

        for (Vehicle vehicle : this.vehicles){
            if(searchFavouriteVehicle(vehicle, vehicleType)){
                return vehicle;
            }
        }
        Vehicle vehicle = this.vehicles.get(ThreadLocalRandom.current().nextInt(this.vehicles.size()));
        searchFavouriteVehicle(vehicle, vehicleType);
        return vehicle;
    }

    public boolean searchFavouriteVehicle(Vehicle vehicle, VehicleFactory.VehicleType vehicleType){
        if(vehicle instanceof BoatVehicle && this.numOfBoats > 0 && vehicleType.equals(VehicleFactory.VehicleType.BOAT)){
                setNumOfBoats(this.numOfBoats - 1);
                return true;
        }

        if(vehicle instanceof BusVehicle && this.numOfBuses > 0 && vehicleType.equals(VehicleFactory.VehicleType.BUS)){
            setNumOfBuses(this.numOfBuses - 1);
            return true;
        }

        if(vehicle instanceof PlaneVehicle && this.numOfPlanes > 0 && vehicleType.equals(VehicleFactory.VehicleType.PLANE)){
            setNumOfPlanes(this.numOfPlanes - 1);
            return true;
        }

        if(vehicle instanceof TaxiVehicle && this.numOfTaxis > 0 && vehicleType.equals(VehicleFactory.VehicleType.TAXI)){
            setNumOfTaxis(this.numOfTaxis - 1);
            return true;
        }
        return false;
    }
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }


    public int getNumOfBuses() {
        return numOfBuses;
    }

    public void setNumOfBuses(int numOfBuses) {
        this.numOfBuses = numOfBuses;
    }

    public int getNumOfTaxis() {
        return numOfTaxis;
    }

    public void setNumOfTaxis(int numOfTaxis) {
        this.numOfTaxis = numOfTaxis;
    }

    public int getNumOfPlanes() {
        return numOfPlanes;
    }

    public void setNumOfPlanes(int numOfPlanes) {
        this.numOfPlanes = numOfPlanes;
    }

    public int getNumOfBoats() {
        return numOfBoats;
    }

    public void setNumOfBoats(int numOfBoats) {
        this.numOfBoats = numOfBoats;
    }

    @Override
    public String toString() {
        return "\nAgency{" +
                "mapPassengerVehicle=" + mapPassengerVehicle +
                '}';
    }
}
