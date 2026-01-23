package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public class KeyPairGenerator {
    public KeyPair generate() {
        BigInteger p = new BigInteger("17");
        BigInteger q = new BigInteger("11");
        BigInteger n = p.multiply(q);
        //BigInteger phi_n = p.min(BigInteger.ONE).multiply(q.min(BigInteger.ONE));
        BigInteger e = new BigInteger("7");
        BigInteger d = new BigInteger("23");
        PrivateKey privateKey = new PrivateKey(e, n);
        PublicKey publicKey = new PublicKey(d, n);
        return new KeyPair(privateKey, publicKey);
    }
}
