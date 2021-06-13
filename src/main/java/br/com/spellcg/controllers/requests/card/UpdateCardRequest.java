package br.com.spellcg.controllers.requests.card;

import br.com.spellcg.controllers.requests.Request;
import br.com.spellcg.domain.Card;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;
import java.util.UUID;

public class UpdateCardRequest extends Request<Card> {
    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("rarity")
    private String rarity;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("quantity")
    private Integer quantity;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRarity() {
        return rarity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Card toCard(Converter<UpdateCardRequest, Card> converter) {
        return converter.convert(this);
    }
}
