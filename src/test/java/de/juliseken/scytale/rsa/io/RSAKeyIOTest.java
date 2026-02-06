package de.juliseken.scytale.rsa.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import de.juliseken.scytale.math.impl.NumberTheoryMock;
import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;
import de.juliseken.scytale.rsa.impl.RSAKeyPairGenerator;
import de.juliseken.scytale.rsa.impl.RSAPrivateKeyImpl;
import de.juliseken.scytale.rsa.impl.RSAPublicKeyImpl;
import de.juliseken.scytale.rsa.io.api.RSAKeyReader;
import de.juliseken.scytale.rsa.io.api.RSAKeyWriter;
import de.juliseken.scytale.rsa.io.impl.RSAPemKeyReader;
import de.juliseken.scytale.rsa.io.impl.RSAPemKeyWriter;
import de.juliseken.scytale.rsa.io.impl.RSAPropertiesKeyReader;
import de.juliseken.scytale.rsa.io.impl.RSAPropertiesKeyWriter;

public class RSAKeyIOTest {

    @Test
    public void testRSAPropertiesPublicKeyIO(@TempDir Path tempDir) throws IOException {
        Path pubPath = tempDir.resolve("rsa-naive.pub");
        RSAPublicKey pub = new RSAPublicKeyImpl(BigInteger.valueOf(19), BigInteger.valueOf(60));
        RSAKeyWriter w = new RSAPropertiesKeyWriter();
        RSAKeyReader r = new RSAPropertiesKeyReader();

        w.writePublic(pub, pubPath);
        RSAPublicKey pubFromFile = r.readPublic(pubPath);

        assertEquals(pub, pubFromFile);
    }

    @Test
    public void testRSAPropertiesPrivateKeyIO(@TempDir Path tempDir) throws IOException {
        Path privPath = tempDir.resolve("rsa-naive");
        RSAPrivateKey priv = new RSAPrivateKeyImpl(BigInteger.valueOf(19), BigInteger.valueOf(60));
        RSAKeyWriter w = new RSAPropertiesKeyWriter();
        RSAKeyReader r = new RSAPropertiesKeyReader();

        w.writePrivate(priv, privPath);
        RSAPrivateKey privFromFile = r.readPrivate(privPath);

        assertEquals(priv, privFromFile);
    }

    @Test
    public void testRSAPemPropertiesPublicKeyIO(@TempDir Path tempDir) throws IOException {
        Path pubPath = tempDir.resolve("rsa-naive.pub");
        RSAKeyPairGenerator keygen = new RSAKeyPairGenerator();

        RSAPublicKey pub = keygen.generate(new NumberTheoryMock(), 512).getPublicKey();
        RSAPemKeyWriter w = new RSAPemKeyWriter();
        RSAPemKeyReader r = new RSAPemKeyReader();
        
        w.writePublic(pub, pubPath);
        RSAPublicKey pubFromFile = r.readPublic(pubPath);

        assertEquals(pub, pubFromFile);
    }

    @Test
    public void testRSAPemPropertiesPrivateKeyIO(@TempDir Path tempDir) throws IOException {
        Path privPath = tempDir.resolve("rsa-naive");
        RSAKeyPairGenerator keygen = new RSAKeyPairGenerator();

        RSAPrivateKey priv = keygen.generate(new NumberTheoryMock(), 512).getPrivateKey();
        RSAPemKeyWriter w = new RSAPemKeyWriter();
        RSAPemKeyReader r = new RSAPemKeyReader();
        
        w.writePrivate(priv, privPath);
        RSAPrivateKey privFromFile = r.readPrivate(privPath);

        assertEquals(priv, privFromFile);
    }
}
