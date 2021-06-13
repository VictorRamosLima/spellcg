package br.com.spellcg.persistence.repositories;

import br.com.spellcg.domain.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.UUID;

@RepositoryDefinition(domainClass = Card.class, idClass = UUID.class)
public interface CardRepository {
    Card save(Card entity);
    Card findByIdAndIsActiveIsTrue(UUID id);
    Page<Card> findAll(Pageable pageable);
}
