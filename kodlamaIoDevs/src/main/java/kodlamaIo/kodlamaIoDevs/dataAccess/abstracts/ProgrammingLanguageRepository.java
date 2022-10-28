package kodlamaIo.kodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {

	void save(ProgrammingLanguage programmingLanguage);
	void delete(ProgrammingLanguage programmingLanguage);
	void modify(ProgrammingLanguage programmingLanguage) throws Exception;
	
	List<ProgrammingLanguage> getList();
	ProgrammingLanguage getById(int id);
	
}
