package br.com.spellcg.persistence.daos;

import br.com.spellcg.domain.Card;
import br.com.spellcg.persistence.daos.resources.CardNotFoundException;
import br.com.spellcg.persistence.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CardDAO {
    private CardRepository cardRepository;

    public Card create(Card card) {
        return cardRepository.save(card);
    }

    public Card findById(UUID id) {
        var foundCard = cardRepository.findByIdAndIsActiveIsTrue(id);

        if (foundCard == null) {
            throw new CardNotFoundException(id);
        }

        return foundCard;
    }

    public Card update(Card card) {
        var foundCard = findById(card.getId());

        foundCard.setName(Optional.ofNullable(card.getName()).orElse(foundCard.getName()));
        foundCard.setRareness(Optional.ofNullable(card.getRareness()).orElse(foundCard.getRareness()));
        foundCard.setDescription(Optional.ofNullable(card.getDescription()).orElse(foundCard.getDescription()));
        foundCard.setQuantity(Optional.ofNullable(card.getQuantity()).orElse(foundCard.getQuantity()));
        foundCard.setPrice(Optional.ofNullable(card.getPrice()).orElse(foundCard.getPrice()));

        return cardRepository.save(foundCard);
    }

    public void delete(UUID id) {
        var foundCard = cardRepository.findByIdAndIsActiveIsTrue(id);
        foundCard.setActive(false);

        cardRepository.save(foundCard);
    }

    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
}
