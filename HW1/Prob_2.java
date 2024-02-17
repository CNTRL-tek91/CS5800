
class Ship{
    String shipName;
    String shipBuildYear;

    //Constructor
    public Ship (String shipName, String shipBuildYear){
        this.shipName = shipName;
        this.shipBuildYear = shipBuildYear;
    }


    //Get Methods
    public String getShipName() {return shipName;}
    public String getShipBuildYear() {return shipBuildYear;}


    //Set Methods
    public void setShipName(String shipName) {this.shipName = shipName;}
    public void setShipBuildYear (String shipBuildYear) {this.shipBuildYear = shipBuildYear;}

    void display() {
        System.out.println("Ship Name: " + shipName);
        System.out.println("Build Year: " + shipBuildYear + "\n");
    }

}

class CruiseShip extends Ship {
    int maxPassengerNumber;


    //Constructor
    public CruiseShip(String shipName, String shipBuildYear, int maxPassengerNumber){
        super (shipName, shipBuildYear);
        this.maxPassengerNumber = maxPassengerNumber;
    }


    //Get Methpds
    public int getMaxPassengerNumber() {
        return maxPassengerNumber;
    }


    //Set Methods
    public void setMaxPassengerNumber(int maxPassengerNumber) {
        this.maxPassengerNumber = maxPassengerNumber;
    }


    //Display ship name and max number of passengers

    @Override void display() {
        System.out.println("Cruise Ship Name: " + shipName);
        System.out.println ("Maximum Number of Passengers: " + maxPassengerNumber + "\n");
    }
}


class CargoShip extends Ship{
    int cargoCapacityInTonnage;


    //Constructor
    public CargoShip(String shipName, String shipBuildYear, int cargoCapacityInTonnage){
        super (shipName, shipBuildYear);
        this.cargoCapacityInTonnage = cargoCapacityInTonnage;
    }


    //Get Methods
    public int getCargoCapacityInTonnage() {
        return cargoCapacityInTonnage;
    }


    //Set Methods
    public void setCargoCapacityInTonnage(int cargoCapacityInTonnage) {
        this.cargoCapacityInTonnage = cargoCapacityInTonnage;
    }


    //Display Function

    @Override void display() {
        System.out.println ("Cargo Ship Name: " + shipName);
        System.out.println ("Cargo Capacity(Tons): " + cargoCapacityInTonnage + "\n");
    }
}


public class Prob_2 {
    public static void main (String[] args)
    {
        Ship[] shipArray = new Ship[3];
        shipArray[0] = new Ship("BattleShip Alpha", "2015");
        shipArray[1] = new CruiseShip("Icon of the Seas", "2015", 10_000);
        shipArray[2] = new CargoShip("Cargo Ship a1", "2016", 220_000 );

        for (int i = 0; i < shipArray.length; i++)
        {
            shipArray[i].display();
        }

    }
}
