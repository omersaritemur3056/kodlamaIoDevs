package kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProgrammingTechnology {

	private String name;
	private int programmingLanguageId;
}
