package kodlamaIo.kodlamaIoDevs.business.abstracts;

import java.util.List;

import kodlamaIo.kodlamaIoDevs.business.requests.programmingLanguageRequest.CreateProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingLanguageRequest.DeleteProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingLanguageRequest.UpdateProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingLanguageResponse.GetListProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingLanguageResponse.GetProgrammingLanguageById;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	void add(CreateProgrammingLanguage createProgrammingLanguage) throws Exception;
	void delete(DeleteProgrammingLanguage deleteProgrammingLanguage) throws Exception;
	void update(UpdateProgrammingLanguage programmingLanguage) throws Exception;
	
	List<GetListProgrammingLanguage> getAll();
	GetProgrammingLanguageById getProgrammingLanguageById(int id) throws Exception;
}
