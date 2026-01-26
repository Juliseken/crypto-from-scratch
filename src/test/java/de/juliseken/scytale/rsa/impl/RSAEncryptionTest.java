package de.juliseken.scytale.rsa.impl;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        RSAKeyPair keyPair = new RSAKeyPairGenerator().generate(new NumberTheoryNaive());
        Message message = new MessageImpl(new BigInteger("88"));

        PublicKeyEncryption<RSAPrivateKey, RSAPublicKey> encryption = new RSAEncryption();
        CipherText cipherText = encryption.encrypt(message, keyPair.getPublicKey());

        Message decryptedMessage = encryption.decrypt(cipherText, keyPair.getPrivateKey());
        assertEquals(message, decryptedMessage);
    }
}
