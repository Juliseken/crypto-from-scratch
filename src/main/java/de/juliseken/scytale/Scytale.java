package de.juliseken.scytale;

import java.math.BigInteger;

import de.juliseken.scytale.rsa.KeyPair;
import de.juliseken.scytale.rsa.KeyPairGenerator;
import de.juliseken.scytale.rsa.RSAEncryption;

public class Scytale {
    public static void main(String[] args) {
        System.out.println("Hello Scytale!");

        KeyPair keyPair = new KeyPairGenerator().generate();
        BigInteger message = new BigInteger("88");

        System.out.println("Original message: " + message);

        RSAEncryption rsaEncryption = new RSAEncryption();
        BigInteger cipherText = rsaEncryption.encrypt(message, keyPair.getPublicKey());

        System.out.println("Encrypted message: " + cipherText);

        BigInteger decryptedMessage = rsaEncryption.decrypt(cipherText, keyPair.getPrivateKey());
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
