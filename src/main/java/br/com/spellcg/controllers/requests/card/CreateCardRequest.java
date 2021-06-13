package br.com.spellcg.controllers.requests.card;

import br.com.spellcg.controllers.requests.Request;
import br.com.spellcg.domain.Card;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.convert.converter.Converter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateCardRequest extends Request<Card> {
    @JsonProperty("name")
    @NotNull(message = "{name.notEmpty}")
    private String name;

    @JsonProperty("description")
    @NotNull(message = "{description.notEmpty}")
    private String description;

    @JsonProperty("rarity")
    @NotNull(message = "{rarity.notEmpty}")
    private String rarity;

    @JsonProperty("price")
    @NotNull(message = "{price.notEmpty}")
    private BigDecimal price;

    @JsonProperty("quantity")
    @NotNull(message = "{quantity.notEmpty}")
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

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Card toCard(Converter<CreateCardRequest, Card> converter) {
        return converter.convert(this);
    }
}
