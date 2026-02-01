package de.juliseken.scytale.text.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class BlockIOTest {

    @Test
    public void testBlockIO(@TempDir Path tempDir) throws IOException {
        Path messagePath = tempDir.resolve("message.txt");
        List<byte[]> blocks = new ArrayList<byte[]>();
        BlockInput blockInput = new BlockInput();
        BlockOutput blockOutput = new BlockOutput();
        byte[] block = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07};
        blocks.add(block);

        blockOutput.writeBlocks(blocks, messagePath);
        List<byte[]> blocksRead = blockInput.readBlocks(messagePath, 8);
        
        assertEquals(blocks.size(), blocksRead.size());
        for (int i = 0; i < blocks.size(); i++) {
            assertArrayEquals(blocks.get(i), blocksRead.get(i));
        }
    }
}
