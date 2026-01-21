package de.juliseken.scytale.math;

import java.math.BigInteger;

public class NumberTheory {
    /** 
     * Computes the greatest common divisor of n and m.
     * Uses Euclid's algorithm.
     */
    public static BigInteger gcd(BigInteger n, BigInteger m) {
        while (!m.equals(BigInteger.ZERO)) {
            BigInteger temp = m;
            m = n.mod(m);
            n = temp;
        }
        return n;
    }
}
