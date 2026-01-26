package de.juliseken.scytale.math.impl;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

import de.juliseken.scytale.math.api.NumberTheory;

public class NumberTheoryNaiveTest {

    @Test
    public void testGcd() {
        NumberTheory nt = new NumberTheoryNaive();
        assertEquals(
                nt.gcd(BigInteger.valueOf(54), BigInteger.valueOf(24)),
                BigInteger.valueOf(54).gcd(BigInteger.valueOf(24))
        );
        assertEquals(
                nt.gcd(BigInteger.valueOf(54), BigInteger.valueOf(24)),
                BigInteger.valueOf(54).gcd(BigInteger.valueOf(24))
        );
        assertEquals(
                nt.gcd(BigInteger.valueOf(0), BigInteger.valueOf(10)),
                BigInteger.valueOf(0).gcd(BigInteger.valueOf(10))
        );
    }

    @Test
    public void testIsPrime() {
        NumberTheory nt = new NumberTheoryNaive();
        assert(!nt.isPrime(new BigInteger("1")));
        assert(nt.isPrime(new BigInteger("2")));
        assert(nt.isPrime(new BigInteger("3")));
        assert(!nt.isPrime(new BigInteger("4")));
        assert(nt.isPrime(new BigInteger("5")));
        assert(!nt.isPrime(new BigInteger("6")));
        assert(nt.isPrime(new BigInteger("7")));
        assert(!nt.isPrime(new BigInteger("8")));
    }

    @Test
    public void testGeneratePrime() {
        NumberTheory nt = new NumberTheoryNaive();
        assert(nt.isPrime(nt.generatePrime()));
        assert(nt.isPrime(nt.generatePrime()));
        assert(nt.isPrime(nt.generatePrime()));
        assert(nt.isPrime(nt.generatePrime()));
        assert(nt.isPrime(nt.generatePrime()));
        assert(nt.isPrime(nt.generatePrime()));
    }

    @Test
    public void testGenerateRelativePrime() {
        NumberTheory nt = new NumberTheoryNaive();
        BigInteger n = new BigInteger("10");
        BigInteger relativePrime = nt.generateRelativePrime(n);
        BigInteger gcd = nt.gcd(new BigInteger("10"), relativePrime);
        assertEquals(gcd, BigInteger.ONE);
    }
}
