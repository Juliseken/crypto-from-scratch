package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public class PublicKeyImpl extends AbstractKey implements PublicKey {

    public PublicKeyImpl(BigInteger exponent, BigInteger modulus) {
        super(exponent, modulus);
    }
}
