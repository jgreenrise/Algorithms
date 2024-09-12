package designpattern.decorator;

public abstract class CoffeeDecorator implements Coffee {
    Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int price() {
        return coffee.price();
    }

    @Override
    public String ingredients() {
        return coffee.ingredients();
    }
}
