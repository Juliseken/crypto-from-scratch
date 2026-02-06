package de.juliseken.scytale.rsa.io.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import de.juliseken.scytale.rsa.api.RSAPrivateKey;
import de.juliseken.scytale.rsa.api.RSAPublicKey;
import de.juliseken.scytale.rsa.impl.RSAPrivateKeyImpl;
import de.juliseken.scytale.rsa.impl.RSAPublicKeyImpl;
import de.juliseken.scytale.rsa.io.api.RSAKeyReader;

public class RSAPemKeyReader implements RSAKeyReader {

    private static byte[] readPem(Path path, String begin, String end) throws IOException {
        String pem = Files.readString(path, StandardCharsets.US_ASCII);

        pem = pem
            .replace(begin, "")
            .replace(end, "")
            .replaceAll("\\s", "");

        return Base64.getDecoder().decode(pem);
    }

    @Override
    public RSAPrivateKey readPrivate(Path path) throws IOException {
        try {
            byte[] der = readPem(
                path,
                "-----BEGIN PRIVATE KEY-----",
                "-----END PRIVATE KEY-----"
            );

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(der);
            java.security.PrivateKey javaKey =
                    keyFactory.generatePrivate(spec);

            if (!(javaKey instanceof java.security.interfaces.RSAPrivateKey javaRsaKey)) {
                throw new IllegalArgumentException("Not an RSA private key");
            }

            return new RSAPrivateKeyImpl(javaRsaKey.getPrivateExponent(), javaRsaKey.getModulus());

        } catch (GeneralSecurityException e) {
            throw new IOException("Failed to read RSA private key", e);
        }
    }

    @Override
    public RSAPublicKey readPublic(Path path) throws IOException {
        try {
            byte[] der = readPem(
                path,
                "-----BEGIN PUBLIC KEY-----",
                "-----END PUBLIC KEY-----"
            );

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            X509EncodedKeySpec spec = new X509EncodedKeySpec(der);
            java.security.PublicKey javaKey =
                    keyFactory.generatePublic(spec);

            if (!(javaKey instanceof java.security.interfaces.RSAPublicKey javaRsaKey)) {
                throw new IllegalArgumentException("Not an RSA public key");
            }

            return new RSAPublicKeyImpl(javaRsaKey.getPublicExponent(), javaRsaKey.getModulus());
        } catch (GeneralSecurityException e) {
            throw new IOException("Failed to read RSA public key", e);
        }
    }
}
