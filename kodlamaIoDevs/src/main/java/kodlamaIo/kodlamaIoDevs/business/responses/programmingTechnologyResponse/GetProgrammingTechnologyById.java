package kodlamaIo.kodlamaIoDevs.business.responses.programmingTechnologyResponse;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProgrammingTechnologyById {

	private int id;
	private String name;
	private int programmingLanguageId;
	private String programmingLanguageName;
}
