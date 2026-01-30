package de.juliseken.scytale.rsa.io;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import de.juliseken.scytale.rsa.api.RSAKey;

public class RSAKeyWriter {

    public void write(RSAKey key, String filepath) throws IOException {
        Properties props = new Properties();
        props.setProperty("modulus", key.getModulus().toString());
        props.setProperty("exponent", key.getExponent().toString());
        try (Writer w = Files.newBufferedWriter(Path.of(filepath))) {;
            props.store(w, filepath);
        }
    }
}
