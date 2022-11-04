package kodlamaIo.kodlamaIoDevs.business.responses.programmingTechnologyResponse;

import java.util.List;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListProgrammingTechnology {

	private int id;
	private String name;
	private String programmingLanguageName;
	
	//ProgrammingLanguage programmingLanguage;
}
