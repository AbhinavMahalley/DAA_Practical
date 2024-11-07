import java.util.Scanner;

public class BinomialCoefficientDP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n for C(n, k): ");
        int n = scanner.nextInt();
        System.out.print("Enter k for C(n, k): ");
        int k = scanner.nextInt();

        scanner.close();
        
        if(k > n){
            System.out.println("Invalid input. k cannot be greater than n.");
            return;
        }

        long[][] C = computeBinomialCoefficients(n, k);
        System.out.println("C(" + n + ", " + k + ") = " + C[n][k]);
      
    }

    public static long[][] computeBinomialCoefficients(int n, int k){
        long[][] C = new long[n+1][k+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=Math.min(i, k); j++){
                if(j ==0 || j ==i){
                    C[i][j] =1;
                }
                else{
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
                }
            }
        }

        return C;
    }
}

// Enter n for C(n, k): 5
// Enter k for C(n, k): 2