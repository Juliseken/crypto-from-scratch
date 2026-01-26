package de.juliseken.scytale.math.impl;

import java.math.BigInteger;
import java.util.Random;

import de.juliseken.scytale.math.api.NumberTheory;

public class NumberTheoryNaive implements NumberTheory {

    public boolean isPrime(BigInteger n) {
        BigInteger d = new BigInteger("2");
        boolean divisorFound = false;
        while (!divisorFound && d.compareTo(n.sqrt()) <= 0) {
            divisorFound = n.mod(d) == BigInteger.ZERO;
            d = d.add(BigInteger.ONE);
        }
        return !divisorFound && !n.equals(BigInteger.ONE);
    }

    /** 
     * Computes the greatest common divisor of n and m.
     * Uses Euclid's algorithm.
     */
    public BigInteger gcd(BigInteger n, BigInteger m) {
        while (!m.equals(BigInteger.ZERO)) {
            BigInteger temp = m;
            m = n.mod(m);
            n = temp;
        }
        return n;
    }

    public BigInteger generatePrime() {
        Random random = new Random();
        int randomInt;
        BigInteger p;
        do {
            randomInt = random.nextInt(Integer.MAX_VALUE);
            p = BigInteger.valueOf(randomInt);
        } while (!isPrime(p));
        return p;
    }

    public BigInteger generateRelativePrime(BigInteger n) {
        Random random = new Random();
        BigInteger e;
        do {
            e = new BigInteger(n.bitCount(), random);
        } while (!(e.compareTo(n) < 0) || !gcd(n, e).equals(BigInteger.ONE));
        return e;
    }

    public BigInteger getModInverse(BigInteger n, BigInteger modulus) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getModInverse'");
    }
}
