package de.juliseken.scytale.rsa;

public class KeyPair implements de.juliseken.scytale.api.KeyPair {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public KeyPair(PrivateKey privateKey, PublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
