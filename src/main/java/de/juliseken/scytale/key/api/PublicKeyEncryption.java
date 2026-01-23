package de.juliseken.scytale.key.api;

import de.juliseken.scytale.text.api.CipherText;
import de.juliseken.scytale.text.api.Message;

public interface PublicKeyEncryption<PRIV extends PrivateKey, PUB extends PublicKey> {
    public CipherText encrypt(Message message, PUB key);
    public Message decrypt(CipherText cipherText, PRIV key);
}
