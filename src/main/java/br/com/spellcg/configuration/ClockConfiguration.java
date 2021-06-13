package br.com.spellcg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
class ClockConfiguration {
    @Bean
    public Clock clock(){
        return Clock.systemDefaultZone();
    }
}
