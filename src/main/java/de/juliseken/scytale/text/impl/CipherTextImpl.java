package de.juliseken.scytale.text.impl;

import java.math.BigInteger;

public class CipherTextImpl extends AbstractText implements de.juliseken.scytale.text.api.CipherText {
    public CipherTextImpl(BigInteger content) {
        super(content);
    }
}
