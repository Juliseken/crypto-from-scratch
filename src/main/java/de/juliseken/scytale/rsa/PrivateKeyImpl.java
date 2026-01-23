package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public class PrivateKeyImpl extends AbstractKey implements PrivateKey {

    public PrivateKeyImpl(BigInteger exponent, BigInteger modulus) {
        super(exponent, modulus);
    }
}
