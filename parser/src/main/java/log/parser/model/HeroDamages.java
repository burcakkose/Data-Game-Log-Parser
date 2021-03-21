package log.parser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity (name="heroDamages")
public class HeroDamages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String target;
    @JsonProperty("damage_instances")
    private Integer damageInstances;
    @JsonProperty("total_damage")
    private Integer totalDamage;
}
