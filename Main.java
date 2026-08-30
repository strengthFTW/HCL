/*
5. BufferedReader File Reading

Problem Statement:
Given two files, read them line by line and concatenate
corresponding lines.

For every line:
    print line from file2 + line from file1

Input Format:
- File1: file1.txt
- File2: file2.txt

Output Format:
- Print the concatenated corresponding lines.

Sample Input:

file1.txt:
Hello world

file2.txt:
HackerRank

Sample Output:
HackerRankHello world
*/

import java.io.*;

public class Main {
//Write this function.
    public static void concatenateAndPrint(
            BufferedReader reader1,
            BufferedReader reader2) throws IOException {
//write code from here
                String line1 = null;
                String line2 = null;

                while((line1 = reader1.readLine()) != null &&
                      (line2 = reader2.readLine()) != null) {
                        System.out.print(line2 + line1);
                      }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader1 =
                new BufferedReader(new FileReader("file1.txt"));

        BufferedReader reader2 =
                new BufferedReader(new FileReader("file2.txt"));

        concatenateAndPrint(reader1, reader2);

        reader1.close();
        reader2.close();
    }
}