package Interview.BB;

import java.util.*; 

public class StockSystem {

    int k;
    TreeMap<String, Integer> stocks;

    public StockSystem(int k) {

        this.k = k; 
        this.stocks = new TreeMap<String, Integer>();

    }

    public void buyStock(String stock, int amount) {

         this.stocks.put(stock, this.stocks.getOrDefault(stock, 0) + amount);
        
    }

    public List<String> getTopKStocks() {

        List<String> results = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            
            if (!this.stocks.keySet().iterator().hasNext())
                break;

            results.add(this.stocks.keySet().iterator().next());
        }

        return results;
    }

    class Stock implements Comparable<Stock> {

        String name;
        int amount;

        public Stock(String name, int amount) {

            this.name = name; 
            this.amount = amount; 
        }

        @Override 
        public int compareTo(Stock that) {

            if (this.amount != that.amount)
                return that.amount - this.amount;

            else 
                return this.name.compareTo(that.name);
        }
    }


}