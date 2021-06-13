package br.com.spellcg.domain;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.List;

public class Game extends DomainEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "rareness_list")
    private List<String> rarenessList;
}
