import java.util.Scanner;

public class EightQueens {
    final int N = 8; // Size of the chessboard

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the row (0-7) for the first queen: ");
        int row = scanner.nextInt();
        
        System.out.print("Enter the column (0-7) for the first queen: ");
        int col = scanner.nextInt();

        scanner.close();
        
        // Validate the input
        if (row < 0 || row >= 8 || col < 0 || col >= 8) {
            System.out.println("Invalid position! Row and column values must be between 0 and 7.");
            return;
        }
        
        EightQueens queens = new EightQueens();
        queens.solveWithInitialPosition(row, col);

        
    }


    // Function to print the board
    void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((board[i][j] == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if a queen can be placed on board[row][col]
    boolean isSafe(int[][] board, int row, int col) {
        // Check this row on the left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on the left side
        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Function to solve the N-Queens problem with a specific starting position
    boolean solveNQueens(int[][] board, int col) {
        // If all queens are placed
        if (col >= N)
            return true;

        // Try placing the queen in all rows one by one for the current column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                // Place the queen
                board[i][col] = 1;

                // Recur to place the rest of the queens
                if (solveNQueens(board, col + 1))
                    return true;

                // If placing queen in board[i][col] doesn't lead to a solution,
                // remove the queen (backtrack)
                board[i][col] = 0;
            }
        }

        // If the queen cannot be placed in any row in this column, return false
        return false;
    }

    // Main function to solve the 8-Queens problem with the first queen at a specific position
    boolean solveWithInitialPosition(int row, int col) {
        int[][] board = new int[N][N];
        board[row][col] = 1; // Place the first queen at the specified position

        // Try to solve from the next column
        if (!solveNQueens(board, col + 1)) {
            System.out.println("Solution does not exist from the given initial position");
            return false;
        }

        printBoard(board); // Print one possible solution
        return true;
    }

}


// Enter the row (0-7) for the first queen: 0
// Enter the column (0-7) for the first queen: 0