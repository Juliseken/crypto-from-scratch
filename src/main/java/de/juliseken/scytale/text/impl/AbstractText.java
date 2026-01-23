package de.juliseken.scytale.text.impl;

import java.math.BigInteger;

import de.juliseken.scytale.text.api.Text;

public abstract class AbstractText implements de.juliseken.scytale.text.api.Text {
    private BigInteger content;

    public AbstractText(BigInteger content) {
        this.content = content;
    }

    public BigInteger getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text other = (Text) o;
        return content.equals(other.getContent());
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
