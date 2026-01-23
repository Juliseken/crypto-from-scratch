package de.juliseken.scytale.rsa;

import java.math.BigInteger;

import de.juliseken.scytale.api.PublicKeyEncryption;

public class Encryption implements PublicKeyEncryption<PrivateKey, PublicKey> {

    public BigInteger encrypt(BigInteger message, PublicKey key) {
        return RSAPrimitive.apply(message, key);
    }

    public BigInteger decrypt(BigInteger cipherText, PrivateKey key) {
        return RSAPrimitive.apply(cipherText, key);
    }
}
