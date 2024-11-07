import java.util.*;

public class JobSequencing {
    static class Job {
        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = scanner.nextInt();
        Job[] jobs = new Job[n];

        for(int i=0; i<n; i++) {
            System.out.println("Enter Job " + (i+1) + " details (id, deadline, profit):");
            char id = scanner.next().charAt(0);
            int deadline = scanner.nextInt();
            int profit = scanner.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        jobSequencing(jobs, n);
        scanner.close();
    }

    public static void jobSequencing(Job[] jobs, int n){
        // Sort jobs in decreasing order of profit
        Arrays.sort(jobs, new Comparator<Job>() {
            public int compare(Job a, Job b){
                return b.profit - a.profit;
            }
        });

        // Find the maximum deadline to determine the number of time slots
        int maxDeadline = 0;
        for(Job job : jobs){
            if(job.deadline > maxDeadline){
                maxDeadline = job.deadline;
            }
        }

        // Initialize time slots
        char[] result = new char[maxDeadline];
        Arrays.fill(result, '-');

        int totalProfit = 0;
        int jobCount = 0;

        for(Job job : jobs){
            // Find a time slot for this job, starting from the last possible slot
            for(int j = Math.min(maxDeadline, job.deadline) -1; j >=0; j--){
                if(result[j] == '-'){
                    result[j] = job.id;
                    totalProfit += job.profit;
                    jobCount++;
                    break;
                }
            }
        }

        System.out.println("Following is the optimal job sequence:");
        for(char c : result){
            if(c != '-')
                System.out.print(c + " ");
        }
        System.out.println("\nTotal number of jobs scheduled: " + jobCount);
        System.out.println("Total profit: " + totalProfit);
    }
}


// Enter number of jobs: 4
// Enter Job 1 details (id, deadline, profit):
// a 4 20
// Enter Job 2 details (id, deadline, profit):
// b 1 10
// Enter Job 3 details (id, deadline, profit):
// c 1 40
// Enter Job 4 details (id, deadline, profit):
// d 1 30
