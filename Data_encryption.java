/*
2. Data Encryption (Method Overloading)

Problem Statement:
Implement a DataEncryption class with attributes
encryptionRatio and baseEncryptionValue.

Overload getEncryptedValue() in three ways:

1. No parameters:
   Return baseEncryptionValue + encryptionRatio

2. Integer parameter:
   Return (baseEncryptionValue + encryptionRatio) - encryptedValue

3. String parameter:
   Return (baseEncryptionValue - encryptionRatio) - encryptionAdjustment

Input Format:
- First line: two integers baseEncryptionValue and encryptionRatio.
- Second line: a string or integer parameter.

Output Format:
- Print the encrypted value.

Constraints:
- 1 <= baseEncryptionValue <= 1000
- 1 <= encryptionRatio <= 1000

Sample Input 1:
200 60
NONE

Sample Output 1:
260

Sample Input 2:
200 60
24

Sample Output 2:
236

Sample Input 3:
200 60
"14"

Sample Output 3:
126
*/

import java.util.*;

class DataEncryption {

    int baseEncryptionValue;
    int encryptionRatio;
//Write your code here
    public DataEncryption(int baseEncryptionValue, int encryptionRatio) {
        this.baseEncryptionValue = baseEncryptionValue;
        this.encryptionRatio = encryptionRatio;
    }

    // Only write these getEncryptedValue Methods for overloading

    public int getEncryptedValue() {
        return baseEncryptionValue + encryptionRatio;
    }
    
    public int getEncryptedValue(int getEncryptedValue) {
        return (baseEncryptionValue + encryptionRatio) - getEncryptedValue;
    }

    public int getEncryptedValue(String encryptionAdjustment) {
        String cleanString = encryptionAdjustment.replace("\"","").trim();
        if(encryptionAdjustment.equals("None")) {
            return baseEncryptionValue - encryptionRatio;
        }
           return (baseEncryptionValue - encryptionRatio) - Integer.valueOf(cleanString);
    }
}

public class Data_encryption {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int base = sc.nextInt();
        int ratio = sc.nextInt();

        String input = sc.next();

        DataEncryption obj = new DataEncryption(base, ratio);

        if (input.equals("NONE")) {
            System.out.println(obj.getEncryptedValue());
        }
        else {
            try {
                int value = Integer.parseInt(input);
                System.out.println(obj.getEncryptedValue(value));
            }
            catch (NumberFormatException e) {
                System.out.println(obj.getEncryptedValue(input));
            }
        }

        sc.close();
    }
}