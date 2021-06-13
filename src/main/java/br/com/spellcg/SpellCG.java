package br.com.spellcg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpellCG {
    public static void main(String[] args) {
        SpringApplication.run(SpellCG.class, args);
    }
}
