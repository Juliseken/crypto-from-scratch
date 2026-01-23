package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public class PrivateKey extends Key {
    public PrivateKey(BigInteger exponent, BigInteger modulus) {
        super(exponent, modulus);
    }
}
