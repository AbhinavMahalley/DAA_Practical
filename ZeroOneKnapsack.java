import java.util.*;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];

        for(int i=0; i<n; i++) {
            System.out.println("Enter Item " + (i+1) + " details (value, weight):");
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        System.out.print("Enter the knapsack capacity: ");
        int capacity = scanner.nextInt();

        int maxProfit = knapsackDP(values, weights, n, capacity);
        System.out.println("Maximum profit possible: " + maxProfit);
        scanner.close();
    }

    public static int knapsackDP(int[] values, int[] weights, int n, int capacity){
        int[][] dp = new int[n+1][capacity+1];

        // Build table dp[][] in bottom up manner
        for(int i=0; i<=n; i++){
            for(int w=0; w<=capacity; w++){
                if(i==0 || w==0){
                    dp[i][w] =0;
                }
                else if(weights[i-1] <= w){
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w - weights[i-1]], dp[i-1][w]);
                }
                else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        // Optional: To find which items are included
        System.out.println("Items included in the knapsack:");
        int w = capacity;
        for(int i = n; i >0 && w >0; i--){
            if(dp[i][w] != dp[i-1][w]){
                System.out.println("Item " + i + " (Value: " + values[i-1] + ", Weight: " + weights[i-1] + ")");
                w -= weights[i-1];
            }
        }

        return dp[n][capacity];
    }
}


// Enter number of items: 4
// Enter Item 1 details (value, weight):
// 60 10
// Enter Item 2 details (value, weight):
// 100 20
// Enter Item 3 details (value, weight):
// 120 30
// Enter Item 4 details (value, weight):
// 80 15
// Enter the knapsack capacity: 50
