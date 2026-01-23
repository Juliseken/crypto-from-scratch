package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public abstract class AbstractKey implements Key {
    private BigInteger exponent;
    private BigInteger modulus;

    public AbstractKey(BigInteger exponent, BigInteger modulus) {
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
