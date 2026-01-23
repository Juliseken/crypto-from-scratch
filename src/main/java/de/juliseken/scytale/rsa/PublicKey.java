package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public class PublicKey extends Key {
    public PublicKey(BigInteger exponent, BigInteger modulus) {
        super(exponent, modulus);
    }
}
