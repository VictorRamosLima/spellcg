package br.com.spellcg.converters;

import br.com.spellcg.controllers.requests.card.UpdateCardRequest;
import br.com.spellcg.domain.Card;
import org.springframework.core.convert.converter.Converter;

public class UpdateCardRequestToCardConverter implements Converter<UpdateCardRequest, Card> {
    public Card convert(UpdateCardRequest request) {
        var card = new Card(
            request.getName(),
            request.getDescription(),
            request.getRarity(),
            request.getQuantity(),
            request.getPrice()
        );

        card.setId(request.getId());

        return card;
    }
}
