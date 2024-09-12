package designpattern.decorator;

public class MilkCoffee extends CoffeeDecorator {
    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int price() {
        return super.price() + 30;
    }

    @Override
    public String ingredients() {
        return super.ingredients() + " Milk";
    }
}
