package de.juliseken.scytale.text.codec;

import java.math.BigInteger;

import de.juliseken.scytale.text.api.CipherText;
import de.juliseken.scytale.text.impl.CipherTextImpl;

public class CipherTextBlockCodec {

    private final int blockSize;

    public CipherTextBlockCodec(int blockSize) {
        this.blockSize = blockSize;
    }

    public CipherText fromBytes(byte[] block) {
        return new CipherTextImpl(new BigInteger(1, block));
    }

    public byte[] toBytes(CipherText cipherText) {
        return normalize(cipherText.getContent().toByteArray());
    }

    private byte[] normalize(byte[] raw) {
        if (raw.length > blockSize) {
            throw new IllegalArgumentException("Block too large");
        }

        byte[] normalized = new byte[blockSize];
        System.arraycopy(raw, 0, normalized, blockSize - raw.length, raw.length);
        return normalized;
    }
}
