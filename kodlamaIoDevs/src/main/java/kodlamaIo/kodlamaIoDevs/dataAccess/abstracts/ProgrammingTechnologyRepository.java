package kodlamaIo.kodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology, Integer> {

	//Jpa'nın sağladığı hazır sorgular(query) find, findAll, findBy gibi keyworlerle oluşum sağlanır
	//buna ilave gerekli parametreler bizim kullandığımız değişken isimleri(field) olurlar
	List<ProgrammingTechnology> findAllById(int id);
	List<ProgrammingTechnology> findAllByName(String name);
	
	ProgrammingTechnology findByName(String name);
	ProgrammingTechnology findById(int id);
	
	List<ProgrammingTechnology> findAllByProgrammingLanguage_Name(@Param("name") String name);
	ProgrammingTechnology findByProgrammingLanguage_Name(@Param("name") String name);
}
