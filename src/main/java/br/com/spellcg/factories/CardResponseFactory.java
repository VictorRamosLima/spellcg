package br.com.spellcg.factories;

import br.com.spellcg.controllers.responses.card.CardResponse;
import br.com.spellcg.domain.Card;
import org.springframework.stereotype.Component;

@Component
public class CardResponseFactory {
    public CardResponse build(Card card) {
        return new CardResponse(
            card.getId(),
            card.getName(),
            card.getDescription(),
            card.getRareness(),
            card.getQuantity(),
            card.getPrice(),
            card.getCreatedAt(),
            card.getUpdatedAt()
        );
    }
}
