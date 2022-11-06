package kodlamaIo.kodlamaIoDevs.business.responses.programmingTechnologyResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListProgrammingTechnology {

	private int id;
	private String name;
	private int programmingLanguageId;
	private String programmingLanguageName;
}