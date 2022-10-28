package kodlamaIo.kodlamaIoDevs.business.abstracts;

import java.util.List;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	void add(ProgrammingLanguage programmingLanguage) throws Exception;
	void delete(int id) throws Exception;
	void update(ProgrammingLanguage programmingLanguage) throws Exception;
	
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getProgrammingLanguageById(int id);
}
