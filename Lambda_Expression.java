/*
3. Lambda Expression with Interface

Problem Statement:
You are given an interface MyInterface with a method foo(String s, int x, int y).
Implement a lambda expression that concatenates s with "! " and the sum of x + y.

Input Format:
- First line: integer T (number of test cases).
- For each test case:
  - String s
  - Integers x and y

Output Format:
- Print the string followed by "! " and the sum of x + y.

Sample Input:
1
HackerRank 2 3

Sample Output:
HackerRank! 5
*/

import java.util.*;
interface MyInterface {
    String foo(String s, int x, int y);
}

class Solution {
    public static MyInterface getLambda() {
        //write your code here
        return (s,x,y) -> (s + "!" + (x+y));
        //only write this line lambda function
    }
}

public class Lambda_Expression {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        MyInterface myLambda = Solution.getLambda();

        while (T-- > 0) {

            String s = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(myLambda.foo(s, x, y));
        }

        sc.close();
    }
}