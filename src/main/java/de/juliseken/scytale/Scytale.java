package de.juliseken.scytale;

import de.juliseken.scytale.cli.ScytaleCommand;
import picocli.CommandLine;

public class Scytale {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ScytaleCommand()).execute(args);
        System.exit(exitCode);
    }
}
