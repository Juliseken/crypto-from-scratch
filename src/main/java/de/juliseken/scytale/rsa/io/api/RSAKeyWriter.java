package de.juliseken.scytale.rsa.io.api;

import java.io.IOException;
import java.nio.file.Path;

import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;

public interface RSAKeyWriter {
    void writePublic(RSAPublicKey publicKey, Path path) throws IOException;
    void writePrivate(RSAPrivateKey privateKey, Path path) throws IOException;
}
