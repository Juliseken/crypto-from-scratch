package de.juliseken.scytale.rsa.impl;

import java.math.BigInteger;

import de.juliseken.scytale.key.api.KeyPairGenerator;
import de.juliseken.scytale.math.api.NumberTheory;
import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;

public class RSAKeyPairGenerator implements KeyPairGenerator {
    public RSAKeyPair generate(NumberTheory nt, int bitLength) {
        BigInteger p = nt.generatePrime(bitLength / 2);
        BigInteger q = nt.generatePrime(bitLength / 2);
        while (p.equals(q)) {
            q = nt.generatePrime(bitLength / 2);
        }
        BigInteger n = p.multiply(q);
        BigInteger phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = nt.generateRelativePrime(phi_n);
        BigInteger d = nt.modInverse(e, phi_n);
        RSAPrivateKey privateKey = new RSAPrivateKeyImpl(d, n);
        RSAPublicKey publicKey = new RSAPublicKeyImpl(e, n);
        return new RSAKeyPair(privateKey, publicKey);
    }
}
