package de.juliseken.scytale.rsa.impl;

import java.math.BigInteger;

import de.juliseken.scytale.rsa.api.PrivateKey;
import de.juliseken.scytale.rsa.api.PublicKey;

public class KeyPairGenerator implements de.juliseken.scytale.api.KeyPairGenerator {
    public KeyPair generate() {
        BigInteger p = new BigInteger("17");
        BigInteger q = new BigInteger("11");
        BigInteger n = p.multiply(q);
        //BigInteger phi_n = p.min(BigInteger.ONE).multiply(q.min(BigInteger.ONE));
        BigInteger e = new BigInteger("7");
        BigInteger d = new BigInteger("23");
        PrivateKey privateKey = new PrivateKeyImpl(e, n);
        PublicKey publicKey = new PublicKeyImpl(d, n);
        return new KeyPair(privateKey, publicKey);
    }
}
