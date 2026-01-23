package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public class RSAEncryption {

    public BigInteger encrypt(BigInteger message, PublicKey key) {
        return new RSA().apply(message, key);
    }

    public BigInteger decrypt(BigInteger cipherText, PrivateKey key) {
        return new RSA().apply(cipherText, key);
    }
}
