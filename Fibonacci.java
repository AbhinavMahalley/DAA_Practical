import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position of fib number to calculate Fibonacci: ");
        
        int n = scanner.nextInt();
        scanner.close();

        if(n < 0){
            System.out.println("Invalid input. Please enter a non-negative integer.");
            return;
        }

        //Iterative function for fibonacci
        iterativeFibonacci(n);

        System.out.println("----------------------------------------------------"); 

        int[] stepCount = {0}; 
        
        int fibonacciNumber = recursivefibonacci(n, stepCount);
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacciNumber);
        System.out.println("Number of steps taken by Recursive function: " + stepCount[0]);

        
        
        
        
    }

    public static void iterativeFibonacci(int n){
        
        int steps = 0;
        if(n == 0 || n == 1){
            steps++;
            System.out.println("Fibonacci number at position " + n + " is: " + n);
            System.out.println("Number of steps taken by Iterative function: " + steps);
            return;
        }
        

        long f0 = 0, f1 = 1, temp = 0;
        steps += 2; 

        for(int i = 2; i <= n; i++) {
            temp = f0 + f1;
            f0 = f1;
            f1 = temp;
            steps++; 
        }
        
        System.out.println("Fibonacci number at position " + n + " is: " + f1);
        System.out.println("Number of steps taken by Iterative function: " + steps);
    }


    public static int recursivefibonacci(int n, int[] stepCount) {
        stepCount[0]++; 
        
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return recursivefibonacci(n - 1, stepCount) + recursivefibonacci(n - 2, stepCount);
    }
   
}

//input - 3
