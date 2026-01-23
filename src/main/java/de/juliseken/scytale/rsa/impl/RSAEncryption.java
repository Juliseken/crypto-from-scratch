package de.juliseken.scytale.rsa.impl;

import de.juliseken.scytale.key.api.PublicKeyEncryption;
import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;
import de.juliseken.scytale.text.api.CipherText;
import de.juliseken.scytale.text.api.Message;
import de.juliseken.scytale.text.impl.CipherTextImpl;
import de.juliseken.scytale.text.impl.MessageImpl;

public class RSAEncryption implements PublicKeyEncryption<RSAPrivateKey, RSAPublicKey> {
    public CipherText encrypt(Message message, RSAPublicKey key) {
        return new CipherTextImpl(RSAPrimitive.apply(message.getContent(), key));
    }

    public Message decrypt(CipherText cipherText, RSAPrivateKey key) {
        return new MessageImpl(RSAPrimitive.apply(cipherText.getContent(), key));
    }
}
