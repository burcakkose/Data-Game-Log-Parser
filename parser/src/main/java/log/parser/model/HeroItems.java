package log.parser.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity (name="hero_items")
public class HeroItems {
	private String item;
    private Long timestamp;
}
