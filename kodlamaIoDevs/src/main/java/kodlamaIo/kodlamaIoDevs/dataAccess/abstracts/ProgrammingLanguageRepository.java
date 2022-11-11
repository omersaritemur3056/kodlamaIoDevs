package kodlamaIo.kodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {

	//Jpa'nın sağladığı hazır sorgular(query) find, findAll, findBy gibi keyworlerle oluşum sağlanır
	//buna ilave gerekli parametreler bizim kullandığımız değişken isimleri(field) olurlar
	List<ProgrammingLanguage> findAllById(int id);
	List<ProgrammingLanguage> findAllByName(String name);
	
	ProgrammingLanguage findById(int id);
	ProgrammingLanguage findByNameAndId(String name, int id);
}
