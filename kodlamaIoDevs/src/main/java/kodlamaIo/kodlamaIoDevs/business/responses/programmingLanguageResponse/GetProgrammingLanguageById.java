package kodlamaIo.kodlamaIoDevs.business.responses.programmingLanguageResponse;

import java.util.List;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetProgrammingLanguageById {

	private int id;
	private String name;
	
	private List<ProgrammingTechnology> programmingTechnologies;
}
