package de.juliseken.scytale.rsa;

import java.math.BigInteger;

public class RSA {
    public BigInteger apply(BigInteger input, Key key) {
        return input.modPow(key.getExponent(), key.getModulus());
    }
}
