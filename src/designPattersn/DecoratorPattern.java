package designPattersn;


public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee c = new SimpleCoffee();
        System.out.println(c.getPrice() + ", " + c.getIngredients());

        c = new MilkCofee(c);
        System.out.println(c.getPrice() + ", " + c.getIngredients());

        c = new ChocolateCofee(c);
        System.out.println(c.getPrice() + ", " + c.getIngredients());
    }
}

class ChocolateCofee extends CoffeeDecorator {

    public ChocolateCofee(Coffee c) {
        super(c);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 20;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", cholcate";
    }

}

class MilkCofee extends CoffeeDecorator {

    public MilkCofee(Coffee c) {
        super(c);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 10;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Milk";
    }

}

class CoffeeDecorator implements Coffee {

    Coffee c;

    public CoffeeDecorator(Coffee c) {
        this.c = c;
    }

    @Override
    public int getPrice() {
        return c.getPrice();
    }

    @Override
    public String getIngredients() {
        return c.getIngredients();
    }

}

interface Coffee {
    public int getPrice();

    public String getIngredients();
}

class SimpleCoffee implements Coffee {

    @Override
    public int getPrice() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "black coffee";
    }
}

