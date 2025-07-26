 import java.util.Arrays;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList {
    
    static int N=5;
    static int findMaxValue(int[][] mat) {
        int[] temp1 = new int[N];
        int[] temp2 = new int[N];
        temp1[N - 1] = mat[N - 1][N - 1];
        // Fill temp1
        for (int j = N - 2; j >= 0; j--) {
            temp1[j] = Math.max(temp1[j + 1], mat[N - 1][j]);
        }
        // Stores the maximum value
        int maxValue = Integer.MIN_VALUE;
        // Iterate over the remaining rows
        for (int i = N - 2; i >= 0; i--) {
            // Initialize the last element of temp2
            temp2[N - 1] = Math.max(temp1[N - 1], mat[i][N - 1]);
            for (int j = N - 2; j >= 0; j--) {
                // Update temp2 and maxValue
                maxValue = Math.max(maxValue, temp1[j + 1] - mat[i][j]);
                temp2[j] = Math.max(mat[i][j], Math.max(temp1[j], temp2[j + 1]));
            }
            // Set temp1 to temp2 for the next iteration
            temp1 = Arrays.copyOf(temp2, temp2.length);
        }
        // Return the maximum value
        return maxValue;
    }
    public static void main(String[] args) 
    {
        int[][] mat = {
            { 1, 2, -1, -4, -20 },
            { -8, -3, 4, 2, 1 },
            { 3, 8, 6, 1, 3 },
            { -4, -1, 1, 7, -6 },
            { 0, -4, 10, -5, 1 }
        };
 
        System.out.println("Maximum Value is " + findMaxValue(mat));
    }
}