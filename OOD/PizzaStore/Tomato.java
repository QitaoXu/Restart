package OOD.PizzaStore; 

public class Tomato extends ToppingDecorator {

    Pizza pizza; 

    public Tomato(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Tomato";
    }

    public int getCost() {
        return 10 + pizza.getCost();
    }
}