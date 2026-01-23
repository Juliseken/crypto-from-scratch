package de.juliseken.scytale.rsa;

import java.math.BigInteger;

final class RSAPrimitive {
    public static BigInteger apply(BigInteger input, Key key) {
        return input.modPow(key.getExponent(), key.getModulus());
    }
}
