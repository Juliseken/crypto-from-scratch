package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public interface Key extends de.juliseken.scytale.api.Key {
    public BigInteger getExponent();
    public BigInteger getModulus();
}
