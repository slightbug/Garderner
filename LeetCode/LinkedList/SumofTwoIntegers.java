/*
371. Sum of Two Integers

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

*/

/*

1.  result can be calculated bit by bit, but better be handled parallel: while(b != 0) {carry = a & b; a = a ^ b; b = carry << 1;}
https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation/2

2. substract: 
        while (b != 0) {
                int borrow = (~a) & b;
                a = a ^ b;
                b = borrow << 1;
        }
for addition: handling carry bits is also a procedure of addition
for subtract: handling borrow bits is also a procedure of subtract

3. Summary of Bit Manipulation:
https://discuss.leetcode.com/topic/50315/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently/2

*/

public class Solution {
    /*
    public int getSum(int a, int b) {
        int res = 0, carry = 0, offset, mask, d1, d2;
        for(offset = 0; offset < 32; ++offset) { //including the sign bit
            mask = 1 << offset;
            d1 = a & mask;
            d2 = b & mask;
            res |= d1 ^ d2 ^ carry;
            carry = d1 & d2 | (carry  & (d1 | d2));
            carry <<= 1;
        }
        return res;
    }
    */
    
    // better solution:
    // https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation/2
    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        
        return a;
    }
}
