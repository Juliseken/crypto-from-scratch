package de.juliseken.scytale.text.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BlockInput {

    public List<byte[]> readBlocks(Path path, int blockSize) throws IOException {
        List<byte[]> blocks = new ArrayList<byte[]>();
        byte[] buffer = new byte[blockSize];

        try (InputStream in = Files.newInputStream(path)) {
            int read;
            while ((read = in.read(buffer)) != -1) {
                if (read < blockSize) {
                    byte[] padded = new byte[blockSize];
                    System.arraycopy(buffer, 0, padded, 0, read);
                    blocks.add(padded);
                } else {
                    blocks.add(buffer.clone());
                }
            }
        }
        return blocks;
    }
}
