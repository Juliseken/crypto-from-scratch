package de.juliseken.scytale.rsa.impl;

import java.math.BigInteger;

import de.juliseken.scytale.rsa.api.PublicKey;

public class PublicKeyImpl extends AbstractKey implements PublicKey {

    public PublicKeyImpl(BigInteger exponent, BigInteger modulus) {
        super(exponent, modulus);
    }
}
