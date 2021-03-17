package log.parser.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity (name="hero_kills")
public class HeroKills {
	private String hero;
    private Integer kills;
}
