package de.juliseken.scytale.rsa.impl;

import java.math.BigInteger;

import de.juliseken.scytale.rsa.api.PrivateKey;

public class PrivateKeyImpl extends AbstractKey implements PrivateKey {

    public PrivateKeyImpl(BigInteger exponent, BigInteger modulus) {
        super(exponent, modulus);
    }
}
