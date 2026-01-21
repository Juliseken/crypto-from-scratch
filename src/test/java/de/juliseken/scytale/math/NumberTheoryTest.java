package de.juliseken.scytale.math;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTheoryTest {

    @Test
    public void testGcd() {
        assertEquals(BigInteger.valueOf(6), NumberTheory.gcd(
                BigInteger.valueOf(54), BigInteger.valueOf(24)));
        assertEquals(BigInteger.ONE, NumberTheory.gcd(
                BigInteger.valueOf(17), BigInteger.valueOf(13)));
        assertEquals(BigInteger.valueOf(10), NumberTheory.gcd(
                BigInteger.valueOf(0), BigInteger.valueOf(10)));
    }
}
