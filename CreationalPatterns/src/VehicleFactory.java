public class VehicleFactory {
    enum VehicleType {BUS, TAXI, BOAT, PLANE}

    private static VehicleFactory instance;

    public static VehicleFactory getInstance(){
        if(instance==null){
            instance = new VehicleFactory();
        }
        return instance;
    }

    private VehicleFactory(){
    }

    public Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case BUS:
                return new BusVehicle();
            case TAXI:
                return new TaxiVehicle();
            case BOAT:
                return new BoatVehicle();
            case PLANE:
                return new PlaneVehicle();
            default:
                throw new IllegalArgumentException(String.format("Store type not supported: %s", type));
        }
    }
}
