package de.juliseken.scytale.math.api;

import java.math.BigInteger;

public interface NumberTheory {
    BigInteger gcd(BigInteger n, BigInteger m);
    boolean isPrime(BigInteger n);
    BigInteger generatePrime();
    BigInteger generateRelativePrime(BigInteger n);
    BigInteger modInverse(BigInteger n, BigInteger modulus);
}
