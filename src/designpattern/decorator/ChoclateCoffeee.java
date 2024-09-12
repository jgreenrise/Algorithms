package designpattern.decorator;

public class ChoclateCoffeee extends CoffeeDecorator {
    public ChoclateCoffeee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int price() {
        return super.price() + 10;
    }

    @Override
    public String ingredients() {
        return super.ingredients() + " choclate";
    }
}
