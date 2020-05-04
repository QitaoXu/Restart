package OOD.PizzaStore;

public class Beef extends ToppingDecorator {

    Pizza pizza; 

    public Beef(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Beef";
    }

    public int getCost() {
        return 30 + pizza.getCost();
    }
}