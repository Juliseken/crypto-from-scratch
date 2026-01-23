package de.juliseken.scytale.api;

import java.math.BigInteger;

public interface PublicKeyEncryption<PRIV extends PrivateKey, PUB extends PublicKey> {
    public BigInteger encrypt(BigInteger message, PUB key);
    public BigInteger decrypt(BigInteger cipherText, PRIV key);
}
