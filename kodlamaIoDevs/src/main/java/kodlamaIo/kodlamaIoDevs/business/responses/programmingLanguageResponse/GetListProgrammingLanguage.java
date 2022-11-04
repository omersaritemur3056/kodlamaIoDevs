package kodlamaIo.kodlamaIoDevs.business.responses.programmingLanguageResponse;

import java.util.List;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListProgrammingLanguage {

	private int id;
	private String name;
	private List<String> programmingTechnologies;
	
	//private List<ProgrammingTechnology> programmingTechnologies;
}
