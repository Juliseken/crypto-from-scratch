package de.juliseken.scytale.rsa;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RSAEncryptionTest {
    
    @Test
    public void testEncrypt() {
        KeyPair keyPair = new KeyPairGenerator().generate();
        BigInteger message = new BigInteger("88");

        RSAEncryption rsaEncryption = new RSAEncryption();
        BigInteger cipherText = rsaEncryption.encrypt(message, keyPair.getPublicKey());

        assertEquals(new BigInteger("11"), cipherText);

        BigInteger decryptedMessage = rsaEncryption.decrypt(cipherText, keyPair.getPrivateKey());
        assertEquals(message, decryptedMessage);
    }
}
