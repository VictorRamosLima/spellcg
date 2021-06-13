package br.com.spellcg.controllers;

import br.com.spellcg.controllers.requests.card.CreateCardRequest;
import br.com.spellcg.controllers.requests.card.UpdateCardRequest;
import br.com.spellcg.controllers.responses.card.CardResponse;
import br.com.spellcg.converters.CreateCardRequestToCardConverter;
import br.com.spellcg.converters.UpdateCardRequestToCardConverter;
import br.com.spellcg.facades.CardFacade;
import br.com.spellcg.factories.CardResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("cards")
public class CardController {
    private CardFacade cardFacade;
    private CardResponseFactory cardResponseFactory;

    public CardController(CardFacade cardFacade, CardResponseFactory cardResponseFactory) {
        this.cardFacade = cardFacade;
        this.cardResponseFactory = cardResponseFactory;
    }

    @PostMapping
    public ResponseEntity<CardResponse> create(@Valid @RequestBody CreateCardRequest request) {
        var card = request.toCard(new CreateCardRequestToCardConverter());

        var createdCard = cardFacade.create(card);
        var createdCardResponse = cardResponseFactory.build(createdCard);

        return ResponseEntity.status(CREATED).body(createdCardResponse);
    }

    @PatchMapping("{cardId}")
    public ResponseEntity<CardResponse> update(
        @PathVariable UUID cardId,
        @Valid @RequestBody UpdateCardRequest request
    ) {
        request.setId(cardId);
        var card = request.toCard(new UpdateCardRequestToCardConverter());

        var updatedCard = cardFacade.update(card);
        var updatedCardResponse = cardResponseFactory.build(updatedCard);

        return ResponseEntity.status(OK).body(updatedCardResponse);
    }

    @GetMapping("{cardId}")
    public ResponseEntity<CardResponse> findById(@PathVariable UUID cardId) {
        var foundCard = cardFacade.findById(cardId);
        var cardResponse = cardResponseFactory.build(foundCard);

        return ResponseEntity.status(OK).body(cardResponse);
    }

    @DeleteMapping("{cardId}")
    public ResponseEntity<Void> delete(@PathVariable UUID cardId) {
        cardFacade.delete(cardId);

        return ResponseEntity.status(NO_CONTENT).build();
    }
}
