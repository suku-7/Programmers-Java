import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger numA = new BigInteger(a);
        BigInteger numB = new BigInteger(b);
        return numA.add(numB).toString();
    }
}