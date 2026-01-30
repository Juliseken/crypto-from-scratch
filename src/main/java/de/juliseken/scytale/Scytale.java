package de.juliseken.scytale;

import java.io.IOException;
import java.math.BigInteger;

import de.juliseken.scytale.key.api.PublicKeyEncryption;
import de.juliseken.scytale.math.impl.NumberTheoryNaive;
import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;
import de.juliseken.scytale.rsa.impl.RSAEncryption;
import de.juliseken.scytale.rsa.impl.RSAKeyPair;
import de.juliseken.scytale.rsa.impl.RSAKeyPairGenerator;
import de.juliseken.scytale.rsa.io.RSAKeyReader;
import de.juliseken.scytale.rsa.io.RSAKeyWriter;
import de.juliseken.scytale.text.api.CipherText;
import de.juliseken.scytale.text.api.Message;
import de.juliseken.scytale.text.impl.MessageImpl;

public class Scytale {
    public static void main(String[] args) {
        System.out.println("Hello Scytale!");

        RSAKeyPair keyPair = new RSAKeyPairGenerator().generate(new NumberTheoryNaive());
        RSAKeyWriter writer = new RSAKeyWriter();
        try {
            writer.write(keyPair.getPrivateKey(), "rsa-naive");
            writer.write(keyPair.getPublicKey(), "rsa-naive.pub");
        } catch (IOException e) {
            e.printStackTrace();
        }

        RSAKeyReader reader = new RSAKeyReader();
        RSAPrivateKey privateKey = null;
        RSAPublicKey publicKey = null;
        try {
            privateKey = reader.readPrivate("rsa-naive");
            publicKey = reader.readPublic("rsa-naive.pub");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        RSAKeyPair keyPairFromFile = new RSAKeyPair(privateKey, publicKey);

        Message message = new MessageImpl(new BigInteger("88"));

        System.out.println("Original message: " + message);

        PublicKeyEncryption<RSAPrivateKey, RSAPublicKey> rsaEncryption = new RSAEncryption();
        CipherText cipherText = rsaEncryption.encrypt(message, keyPairFromFile.getPublicKey());

        System.out.println("Encrypted message: " + cipherText);

        Message decryptedMessage = rsaEncryption.decrypt(cipherText, keyPairFromFile.getPrivateKey());
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
