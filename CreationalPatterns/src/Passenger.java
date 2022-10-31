public class Passenger {

    private final String name;
    private final VehicleFactory.VehicleType vehicleType;

    public Passenger(String name, VehicleFactory.VehicleType vehicleType) {
        this.name = name;
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public VehicleFactory.VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "\nPassenger{" +
                "name='" + name + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
