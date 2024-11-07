import java.util.*;

public class FractionalKnapsack {
    static class Item {
        String name;
        int weight;
        int value;
        double ratio;

        Item(String name, int weight, int value){
            this.name = name;
            this.weight = weight;
            this.value = value;
            this.ratio = (double)value / weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        for(int i=0; i<n; i++) {
            System.out.println("Enter Item " + (i+1) + " details (name, weight, value):");
            String name = scanner.next();
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            items[i] = new Item(name, weight, value);
        }

        System.out.print("Enter the knapsack capacity: ");
        int capacity = scanner.nextInt();

        double maxProfit = fractionalKnapsack(items, n, capacity);
        System.out.println("Maximum profit possible: " + maxProfit);
        scanner.close();
    }

    public static double fractionalKnapsack(Item[] items, int n, int capacity){
        // Sort items by descending order of value per unit weight
        Arrays.sort(items, new Comparator<Item>(){
            public int compare(Item a, Item b){
                return Double.compare(b.ratio, a.ratio);
            }
        });

        double totalProfit = 0.0;

        for(Item item : items){
            if(capacity <=0){
                break;
            }

            if(item.weight <= capacity){
                totalProfit += item.value;
                capacity -= item.weight;
                System.out.println("Added whole item: " + item.name);
            }
            else{
                double fraction = ((double)capacity) / item.weight;
                totalProfit += item.value * fraction;
                System.out.println("Added " + String.format("%.2f", fraction*100) + "% of item: " + item.name);
                capacity =0;
            }
        }

        return totalProfit;
    }
}





// Enter number of items: 3
// Enter Item 1 details (name, weight, value):
// A 10 60
// Enter Item 2 details (name, weight, value):
// B 20 100
// Enter Item 3 details (name, weight, value):
// C 30 120
// Enter the knapsack capacity: 50