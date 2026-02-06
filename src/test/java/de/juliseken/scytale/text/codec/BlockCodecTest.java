package de.juliseken.scytale.text.codec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import de.juliseken.scytale.text.api.CipherText;
import de.juliseken.scytale.text.api.Message;
import de.juliseken.scytale.text.impl.CipherTextImpl;
import de.juliseken.scytale.text.impl.MessageImpl;

public class BlockCodecTest {

    @Test
    public void testMessageBlockIO() throws IOException {
        Message m = new MessageImpl(BigInteger.valueOf(42));
        MessageBlockCodec codec = new MessageBlockCodec(8);
        
        byte[] block = codec.toBytes(m);
        Message decoded = codec.fromBytes(block);

        assertEquals(m, decoded);
    }

    @Test
    public void testCipherTextBlockIO() throws IOException {
        CipherText c = new CipherTextImpl(BigInteger.valueOf(42));
        CipherTextBlockCodec codec = new CipherTextBlockCodec(8);
        
        byte[] block = codec.toBytes(c);
        CipherText decoded = codec.fromBytes(block);

        assertEquals(c, decoded);
    }

    @Test
    public void testCipherTextBlockIO2() throws IOException {
        CipherText c = new CipherTextImpl(new BigInteger("2178089801"));
        CipherTextBlockCodec codec = new CipherTextBlockCodec(4);
        
        byte[] block = codec.toBytes(c);
        CipherText decoded = codec.fromBytes(block);

        assertEquals(c, decoded);
    }
}
