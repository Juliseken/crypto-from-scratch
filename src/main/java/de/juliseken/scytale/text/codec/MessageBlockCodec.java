package de.juliseken.scytale.text.codec;

import java.math.BigInteger;

import de.juliseken.scytale.text.api.Message;
import de.juliseken.scytale.text.impl.MessageImpl;

public class MessageBlockCodec {

    private final int blockSize;

    public MessageBlockCodec(int blockSize) {
        this.blockSize = blockSize;
    }

    public Message fromBytes(byte[] block) {
        return new MessageImpl(new BigInteger(1, block));
    }

    public byte[] toBytes(Message message) {
        byte[] raw = message.getContent().toByteArray();
        return normalize(raw);
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
