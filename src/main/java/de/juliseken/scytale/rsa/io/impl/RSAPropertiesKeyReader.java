package de.juliseken.scytale.rsa.io.impl;

import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;
import de.juliseken.scytale.rsa.impl.RSAPrivateKeyImpl;
import de.juliseken.scytale.rsa.impl.RSAPublicKeyImpl;
import de.juliseken.scytale.rsa.io.api.RSAKeyReader;

public class RSAPropertiesKeyReader implements RSAKeyReader {

    public RSAPrivateKey readPrivate(Path path) throws IOException {
        BigInteger[] values = readModulusAndExponent(path);
        return new RSAPrivateKeyImpl(values[0], values[1]);
    }

    public RSAPublicKey readPublic(Path path) throws IOException {
        BigInteger[] values = readModulusAndExponent(path);
        return new RSAPublicKeyImpl(values[0], values[1]);
    }
    
    private BigInteger[] readModulusAndExponent(Path path) throws IOException {
        Properties props = new Properties();
        try (Reader r = Files.newBufferedReader(path)) {
            props.load(r);
        }
        String expStr = props.getProperty("exponent");
        String modStr = props.getProperty("modulus");
        if (modStr == null || expStr == null) {
            throw new IOException("Invalid key file: missing modulus or exponent");
        }
        BigInteger exponent = new BigInteger(expStr.trim());
        BigInteger modulus = new BigInteger(modStr.trim());
        return new BigInteger[]{exponent, modulus};
    }
}
