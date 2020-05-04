package OOD.PizzaStore;

public class PizzaStore 
{ 
    public static void main(String args[]) 
    { 

        System.out.println("Pizza Store");

        Pizza pizza = new FarmHousePizza(); 
        System.out.println(pizza.getDescription() + " " + pizza.getCost());

        pizza = new Tomato(pizza);
        System.out.println(pizza.getDescription() + " " + pizza.getCost());

        pizza = new Beef(pizza);
        System.out.println(pizza.getDescription() + " " + pizza.getCost());
        
   } 
} 