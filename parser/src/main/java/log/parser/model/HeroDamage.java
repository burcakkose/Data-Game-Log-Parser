package log.parser.model;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity (name="hero_damage")
public class HeroDamage {
	private String target;
    @JsonProperty("damage_instances")
    private Integer damageInstances;
    @JsonProperty("total_damage")
    private Integer totalDamage;
}
