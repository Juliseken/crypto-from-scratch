package de.juliseken.scytale.cli.rsa.naive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import de.juliseken.scytale.cli.VersionProvider;
import de.juliseken.scytale.math.impl.NumberTheoryNaive;
import de.juliseken.scytale.rsa.impl.RSAKeyPair;
import de.juliseken.scytale.rsa.impl.RSAKeyPairGenerator;
import de.juliseken.scytale.rsa.io.api.RSAKeyWriter;
import de.juliseken.scytale.rsa.io.impl.RSAPropertiesKeyWriter;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "keygen", mixinStandardHelpOptions = true, versionProvider = VersionProvider.class)
public class RsaNaiveKeygenCommand implements Runnable {

    @Option(names = {"-b", "--bits"}, defaultValue = "32")
    int bitLength;

    @Option(names = {"-o", "--out-dir"}, required = false)
    Path outDir;

    public void run() {
        RSAKeyPairGenerator generator = new RSAKeyPairGenerator();
        RSAKeyWriter w = new RSAPropertiesKeyWriter();

        RSAKeyPair keyPair = generator.generate(new NumberTheoryNaive(), bitLength);
        if (outDir == null) {
            outDir = Paths.get(System.getProperty("user.home")).resolve(".ssh");
        }
        try {
            Files.createDirectories(outDir);
            w.writePrivate(keyPair.getPrivateKey(), outDir.resolve("rsa-naive"));
            w.writePublic(keyPair.getPublicKey(), outDir.resolve("rsa-naive.pub"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
