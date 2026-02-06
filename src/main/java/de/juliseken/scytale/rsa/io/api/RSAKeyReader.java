package de.juliseken.scytale.rsa.io.api;

import java.io.IOException;
import java.nio.file.Path;

import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;

public interface RSAKeyReader {
    RSAPrivateKey readPrivate(Path path) throws IOException;
    RSAPublicKey readPublic(Path path) throws IOException;
}
