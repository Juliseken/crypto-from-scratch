package de.juliseken.scytale.math.impl;

import java.math.BigInteger;
import java.util.Random;

import de.juliseken.scytale.math.api.NumberTheory;

public class NumberTheoryNaive implements NumberTheory {

    private BigInteger randomBigInteger(int bitLength, Random random) {
        BigInteger n = new BigInteger(bitLength, random);
        n = n.setBit(bitLength - 1);
        return n;
    }

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

    public BigInteger generatePrime(int bitLength) {
        Random random = new Random();
        BigInteger n;
        do {
            n = randomBigInteger(bitLength, random);
        } while (!isPrime(n));
        return n;
    }

    public BigInteger generateRelativePrime(BigInteger n) {
        Random random = new Random();
        BigInteger e;
        do {
            e = new BigInteger(n.bitCount(), random);
        } while (!(e.compareTo(n) < 0) || !gcd(n, e).equals(BigInteger.ONE));
        return e;
    }

    public BigInteger modInverse(BigInteger n, BigInteger modulus) {
        assert(gcd(modulus, n).equals(BigInteger.ONE));

        BigInteger r1 = modulus;
        BigInteger x1 = BigInteger.ONE;
        BigInteger y1 = BigInteger.ZERO;

        BigInteger r2 = n;
        BigInteger x2 = BigInteger.ZERO;
        BigInteger y2 = BigInteger.ONE;

        BigInteger r3 = r1.mod(r2);
        BigInteger x3;
        BigInteger y3;

        while (!r3.equals(BigInteger.ZERO)) {
            x3 = x1.subtract(r1.divide(r2).multiply(x2));
            y3 = y1.subtract(r1.divide(r2).multiply(y2));

            r1 = r2;
            r2 = r3;
            x1 = x2;
            y1 = y2;
            x2 = x3;
            y2 = y3;

            r3 = r1.mod(r2);
        }

        return y2;
    }
}
