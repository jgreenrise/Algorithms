package designpattern.decorator;

public class FactoryDesignPatternMain {

    public static void main(String args[]) {
        Coffee cd = new SimpleCofee();
        System.out.println(cd.price() + ", " + cd.ingredients());

        cd = new ChoclateCoffeee(cd);
        System.out.println(cd.price() + ", " + cd.ingredients());

        cd = new MilkCoffee(cd);
        System.out.println(cd.price() + ", " + cd.ingredients());
    }

}
