package org.seekay.kv.client.model;

public class Pair {

    private String key;

    private String value;

    // Keeping object mapper happy
    public Pair () {
        this.key = null;
        this.value = null;
    }

    public Pair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
