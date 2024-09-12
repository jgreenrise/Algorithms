package designpattern.decorator;

public class SimpleCofee implements Coffee {
    public SimpleCofee() {

    }

    @Override
    public int price() {
        return 1;
    }

    @Override
    public String ingredients() {
        return "Black coffee ";
    }
}
