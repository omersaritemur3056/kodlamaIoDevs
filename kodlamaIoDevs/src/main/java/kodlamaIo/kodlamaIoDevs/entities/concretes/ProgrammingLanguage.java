package kodlamaIo.kodlamaIoDevs.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "programming_languages")
@Entity
public class ProgrammingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "programming_language_id")
	private int id;
	
	
	@Column(name = "programming_language_name")
	private String name;
	
	
	@OneToMany(mappedBy = "programmingLanguage", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //camelCase
	private List<ProgrammingTechnology> programmingTechnologies;
	
}
