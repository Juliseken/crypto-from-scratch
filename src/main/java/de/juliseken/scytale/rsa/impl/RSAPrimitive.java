package de.juliseken.scytale.rsa.impl;

import java.math.BigInteger;

import de.juliseken.scytale.rsa.api.Key;

final class RSAPrimitive {
    public static BigInteger apply(BigInteger input, Key key) {
        return input.modPow(key.getExponent(), key.getModulus());
    }
}
