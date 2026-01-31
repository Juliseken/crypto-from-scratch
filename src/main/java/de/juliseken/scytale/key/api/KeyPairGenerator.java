package de.juliseken.scytale.key.api;

import de.juliseken.scytale.math.api.NumberTheory;

public interface KeyPairGenerator {
    public KeyPair generate(NumberTheory nt, int bitLength);
}
