package de.juliseken.scytale.rsa.impl;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import de.juliseken.scytale.key.api.PublicKeyEncryption;
import de.juliseken.scytale.math.impl.NumberTheoryNaive;
import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;
import de.juliseken.scytale.text.api.CipherText;
import de.juliseken.scytale.text.api.Message;
import de.juliseken.scytale.text.impl.MessageImpl;

public class RSAEncryptionTest {

    @Test
    public void testEncrypt() {
        RSAKeyPair keyPair = new RSAKeyPairGenerator().generate(new NumberTheoryNaive(), 64);
        Message message = new MessageImpl(new BigInteger("88"));

        PublicKeyEncryption<RSAPrivateKey, RSAPublicKey> encryption = new RSAEncryption();
        CipherText cipherText = encryption.encrypt(message, keyPair.getPublicKey());

        Message decryptedMessage = encryption.decrypt(cipherText, keyPair.getPrivateKey());
        assertEquals(message, decryptedMessage);
    }

    @Test
    public void testEncrypt2() {
        RSAPrivateKey privateKey = new RSAPrivateKeyImpl(
            BigInteger.valueOf(209794679), BigInteger.valueOf(1722922291));
        RSAPublicKey publicKey = new RSAPublicKeyImpl(
            BigInteger.valueOf(26919), BigInteger.valueOf(1722922291));
        PublicKeyEncryption<RSAPrivateKey, RSAPublicKey> encryption = new RSAEncryption();

        Message m1 = new MessageImpl(BigInteger.valueOf(1214606444));
        // message > modulus will not work
        Message m2 = new MessageImpl(BigInteger.valueOf(1862948719));
        Message m3 = new MessageImpl(BigInteger.valueOf(1919706122));

        CipherText c1 = encryption.encrypt(m1, publicKey);
        CipherText c2 = encryption.encrypt(m2, publicKey);
        CipherText c3 = encryption.encrypt(m3, publicKey);

        Message d1 = encryption.decrypt(c1, privateKey);
        Message d2 = encryption.decrypt(c2, privateKey);
        Message d3 = encryption.decrypt(c3, privateKey);

        assertEquals(m1, d1);
        assertNotEquals(m2, d2);
        assertNotEquals(m3, d3);
    }

    @Test
    public void testEncrypt3() {
        RSAPrivateKey privateKey = new RSAPrivateKeyImpl(
            BigInteger.valueOf(209794679), BigInteger.valueOf(1722922291));
        RSAPublicKey publicKey = new RSAPublicKeyImpl(
            BigInteger.valueOf(26919), BigInteger.valueOf(1722922291));
        PublicKeyEncryption<RSAPrivateKey, RSAPublicKey> encryption = new RSAEncryption();

        Message m1 = new MessageImpl(BigInteger.valueOf(4744556));
        Message m2 = new MessageImpl(BigInteger.valueOf(7106314));
        Message m3 = new MessageImpl(BigInteger.valueOf(5730162));
        Message m4 = new MessageImpl(BigInteger.valueOf(7103498));

        CipherText c1 = encryption.encrypt(m1, publicKey);
        CipherText c2 = encryption.encrypt(m2, publicKey);
        CipherText c3 = encryption.encrypt(m3, publicKey);
        CipherText c4 = encryption.encrypt(m4, publicKey);

        Message d1 = encryption.decrypt(c1, privateKey);
        Message d2 = encryption.decrypt(c2, privateKey);
        Message d3 = encryption.decrypt(c3, privateKey);
        Message d4 = encryption.decrypt(c4, privateKey);

        assertEquals(m1, d1);
        assertEquals(m2, d2);
        assertEquals(m3, d3);
        assertEquals(m4, d4);
    }
}
