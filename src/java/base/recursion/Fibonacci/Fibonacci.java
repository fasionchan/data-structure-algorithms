/*
 * Author: fasion
 * Created time: 2019-07-20 12:02:52
 * Last Modified by: fasion
 * Last Modified time: 2019-07-20 12:16:29
 */

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n==1 || n==2) {
            return 1;
        }
        return Fibonacci.fibonacci(n-1) + Fibonacci.fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(Fibonacci.fibonacci(n));
    }
}
