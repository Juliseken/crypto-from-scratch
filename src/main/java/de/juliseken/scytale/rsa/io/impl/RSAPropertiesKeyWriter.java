package de.juliseken.scytale.rsa.io.impl;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import de.juliseken.scytale.rsa.api.RSAKey;
import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;
import de.juliseken.scytale.rsa.io.api.RSAKeyWriter;

public class RSAPropertiesKeyWriter implements RSAKeyWriter {

    private void write(RSAKey key, Path path) throws IOException {
        Properties props = new Properties();
        props.setProperty("modulus", key.getModulus().toString());
        props.setProperty("exponent", key.getExponent().toString());
        try (Writer w = Files.newBufferedWriter(path)) {;
            props.store(w, "");
        }
    }

    @Override
    public void writePublic(RSAPublicKey publicKey, Path path) throws IOException {
        write(publicKey, path);
    }

    @Override
    public void writePrivate(RSAPrivateKey privateKey, Path path) throws IOException {
        write(privateKey, path);
    }
}
