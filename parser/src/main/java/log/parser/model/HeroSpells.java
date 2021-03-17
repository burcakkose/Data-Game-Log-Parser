package log.parser.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity (name="hero_spells")
public class HeroSpells {
	private String spell;
    private Integer casts;
}
