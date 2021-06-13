package br.com.spellcg.facades;

import br.com.spellcg.domain.Card;
import br.com.spellcg.persistence.daos.CardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

@Service
public class CardFacade implements Facade<Card> {
    private CardDAO cardDAO;

    @Override
    public Card create(Card card) {
        return cardDAO.create(card);
    }

    @Override
    public List<Card> search(Card card) {
        return null;
    }

    @Override
    public Card findById(UUID id) {
        return cardDAO.findById(id);
    }

    @Override
    public List<Card> index(Card card) {
        return null;
    }

    @Override
    public Card update(Card card) {
        return cardDAO.update(card);
    }

    @Override
    public void delete(UUID id) {
        cardDAO.delete(id);
    }

    @Autowired
    public void setCardDAO(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }
}
