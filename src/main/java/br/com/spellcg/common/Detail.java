package br.com.spellcg.common;

public class Detail {
    private final String target;
    private final String message;

    public Detail(String target, String message) {
        this.target = target;
        this.message = message;
    }

    public String getTarget() {
        return target;
    }

    public String getMessage() {
        return message;
    }
}
