package br.com.spellcg.persistence.daos.resources;

import java.util.UUID;

public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(UUID id) {
        super(buildMessage(id));
    }

    private static String buildMessage(UUID id) {
        var stringBuffer = new StringBuffer();

        stringBuffer.append("Card with id ");
        stringBuffer.append(id.toString());
        stringBuffer.append(" was not found");

        return stringBuffer.toString();
    }
}