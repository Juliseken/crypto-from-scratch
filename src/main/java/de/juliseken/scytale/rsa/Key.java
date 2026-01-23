package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public class Key {
    private BigInteger exponent;
    private BigInteger modulus;

    public Key(BigInteger exponent, BigInteger modulus) {
        this.exponent = exponent;
        this.modulus = modulus;
    }

    public BigInteger getExponent() {
        return exponent;
    }

    public BigInteger getModulus() {
        return modulus;
    }
}
