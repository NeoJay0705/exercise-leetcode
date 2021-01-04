package org.exercise.string;

// 67

public class AddBinary {
    public String addBinary(String a, String b) {
        int sum = 0;
        int bit = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;

        do {
            int numA = i > -1 ? a.charAt(i) - '0' : 0;
            int numB = j > -1 ? b.charAt(j) - '0' : 0;
            sum = numA + numB + carry;
            bit = sum % 2;
            carry = sum / 2;
            sb.insert(0, bit);

            --i;
            --j;
        } while ( ( i > -1 && j > -1 ) ||  carry == 1 );

        if ( i > -1 && j < 0 ) {
            sb.insert(0, a.substring(0, i + 1));
        }
        else if ( j > -1 && i < 0 ) {
            sb.insert(0, b.substring(0, j + 1));
        }

        return sb.toString();
    }
}
