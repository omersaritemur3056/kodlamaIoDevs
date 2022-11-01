package kodlamaIo.kodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {

	void save(ProgrammingLanguage programmingLanguage);
	void delete(int id);
	void modify(ProgrammingLanguage programmingLanguage) throws Exception;
	
	List<ProgrammingLanguage> getList();
	ProgrammingLanguage getById(int id);
	
}
