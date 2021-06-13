package br.com.spellcg.converters;

import br.com.spellcg.controllers.requests.card.CreateCardRequest;
import br.com.spellcg.domain.Card;
import org.springframework.core.convert.converter.Converter;

public class CreateCardRequestToCardConverter implements Converter<CreateCardRequest, Card> {
    public Card convert(CreateCardRequest request) {
        return new Card(
            request.getName(),
            request.getDescription(),
            request.getRarity(),
            request.getQuantity(),
            request.getPrice()
        );
    }
}
