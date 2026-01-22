package de.juliseken.scytale.math;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTheoryTest {

    @Test
    public void testGcd() {
        assertEquals(
                NumberTheory.gcd(BigInteger.valueOf(54), BigInteger.valueOf(24)),
                BigInteger.valueOf(54).gcd(BigInteger.valueOf(24))
        );
        assertEquals(
                NumberTheory.gcd(BigInteger.valueOf(54), BigInteger.valueOf(24)),
                BigInteger.valueOf(54).gcd(BigInteger.valueOf(24))
        );
        assertEquals(
                NumberTheory.gcd(BigInteger.valueOf(0), BigInteger.valueOf(10)),
                BigInteger.valueOf(0).gcd(BigInteger.valueOf(10))
        );
    }
}
