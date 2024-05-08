import java.util.ArrayList;
import java.util.List;
interface StateOfVendingMachine{
    void selectSnack(String snackName);
    void insertMoney(double amount);
    void returnItem();
}

class Snack{
    private String name;
    private double price;
    private int quantity;

    //Default Constructor
    public Snack(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Getter Methods
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    //Set Methods
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}

//Classes for state of the vending machine: Idle, Waiting for Money, Dispensing Snack

class Idle implements StateOfVendingMachine{
    private VendingMachine vendingMachine;

    //Default Constructor
    public Idle(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    //Implementation of interface methods
    @Override
    public void selectSnack(String snackName){
        vendingMachine.setSelectedSnack(snackName);
        vendingMachine.setState(vendingMachine.getWaitingForMoneyState());
        System.out.println("Selected Snack: " + snackName);
    }

    @Override
    public void insertMoney(double amount){
        System.out.println("Pick snack");
    }

    @Override
    public void returnItem(){
        System.out.println("Pick snack");
    }

}

class WaitingForMoney implements StateOfVendingMachine{
    private VendingMachine vendingMachine;

    public WaitingForMoney(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    //Implementation of interface methods
    @Override
    public void selectSnack(String snackName){
        System.out.println("Waiting for Money");
    }

    @Override
    public void insertMoney(double amount){
        double snackPrice = vendingMachine.getSelectedSnack().getPrice();

        if(amount >= snackPrice){
            vendingMachine.setState(vendingMachine.getDispensingSnackState());
            System.out.println("Using: " + amount);

        }
        else{
            System.out.println("Not enough money!");
        }
    }

    @Override
    public void returnItem(){
        System.out.println("Insert money");
    }
}

class DispensingSnack implements StateOfVendingMachine{
    private VendingMachine vendingMachine;

    public DispensingSnack(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    //Implementation for interface methods
    public void selectSnack(String snackName){
        System.out.println("Snack already selected");
    }

    @Override
    public void insertMoney(double amount){
        System.out.println(amount + "is already inserted");
    }

    @Override
    public void returnItem(){
        Snack selectedSnack = vendingMachine.getSelectedSnack();

        if(selectedSnack.getQuantity() > 0)
        {
            System.out.println("Dispensing" + selectedSnack.getName());
            selectedSnack.setQuantity(selectedSnack.getQuantity() - 1);
            vendingMachine.setState(vendingMachine.getIdle());
        }
        else{
            System.out.println("Out of stock on: " + selectedSnack.getName());
            vendingMachine.setState(vendingMachine.getIdle());
        }
    }
}

class ChainOfResponsibility{
    public List<Snack> snackList = new ArrayList<>();
    private StateOfVendingMachine state;

    public void addSnack(Snack snack){
        snackList.add(snack);
    }

    public void setNextState(StateOfVendingMachine nextState){
        state = nextState;
    }

    public void request(String snackName){
        for(Snack snack : snackList){
            if(snack.getName().equals(snackName)){
                state.selectSnack(snackName);
                return;
            }
        }
        System.out.println("Error");
    }
}

class VendingMachine{
    private StateOfVendingMachine currentState;
    private ChainOfResponsibility responsibility;
    private Snack selectedSnack;

    private Idle idle;
    private WaitingForMoney waitMoney;
    private DispensingSnack dispensingSnack;

    //Default Constructor
    public VendingMachine(){
        idle = new Idle(this);
        waitMoney = new WaitingForMoney(this);
        dispensingSnack = new DispensingSnack(this);

        currentState = idle;
        responsibility = new ChainOfResponsibility();
        initializeSnacks();
    }

    private void initializeSnacks(){
        responsibility.addSnack(new Snack("Cheez-its", 1, 10));
        responsibility.addSnack(new Snack("Sour Patch", 1.50, 10));
        responsibility.addSnack(new Snack("Cheetos", 1.50, 10));
        responsibility.addSnack(new Snack("Doritos", 2, 10));
        responsibility.addSnack(new Snack("Coke", 1, 10));
        responsibility.addSnack(new Snack("Snickers", 1, 0));
    }

    public void selectSnack(String snackName){
        currentState.selectSnack(snackName);
    }

    public void insertMoney(double amount){
        currentState.insertMoney(amount);
    }

    public void returnItem(){
        currentState.returnItem();
    }

    public void setState(StateOfVendingMachine state){
        this.currentState = state;
    }

    public StateOfVendingMachine getIdle(){
        return idle;
    }
    public StateOfVendingMachine getWaitingForMoneyState(){
        return waitMoney;
    }
    public StateOfVendingMachine getDispensingSnackState(){
        return dispensingSnack;
    }

    public Snack getSelectedSnack(){
        return selectedSnack;
    }

    public void setSelectedSnack(String snackName){
        for(Snack snack : responsibility.snackList){
            if(snack.getName().equals(snackName)){
                this.selectedSnack = snack;
                return;
            }
        }
    }

}



public class vm {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(1.50);
        vendingMachine.returnItem();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(1);
        vendingMachine.returnItem();
    }

}