package de.juliseken.scytale.text.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BlockOutput {

    public void writeBlocks(List<byte[]> blocks, Path path) throws IOException {
        try (OutputStream out = Files.newOutputStream(path)) {
            for (byte[] block : blocks) {
                out.write(block);
            }
        }
    }
}
