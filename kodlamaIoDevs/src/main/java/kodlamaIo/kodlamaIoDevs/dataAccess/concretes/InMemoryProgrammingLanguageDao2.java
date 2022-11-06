package kodlamaIo.kodlamaIoDevs.dataAccess.concretes;

//@Repository("primary")
////@Primary
//public class InMemoryProgrammingLanguageDao2 implements ProgrammingLanguageRepository {
//
//	List<ProgrammingLanguage> programmingLanguages;
//	//Collection<ProgrammingLanguage> programmingLanguages2 = new ArrayList<ProgrammingLanguage>();
//
//	public InMemoryProgrammingLanguageDao2() {
//		programmingLanguages = new ArrayList<ProgrammingLanguage>();
//		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
//		programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
//	}
//	
//	
//	@Override
//	public void save(ProgrammingLanguage programmingLanguage) {
//		
//		programmingLanguages.add(programmingLanguage);
//	}
//
//	@Override
//	public void delete(int id) {
//		
//		programmingLanguages.removeIf(PL -> PL.getId() == id);
//	}
//
//	@Override
//	public void modify(ProgrammingLanguage programmingLanguage) throws Exception {
//		
//		for (ProgrammingLanguage language : programmingLanguages) {
//			if (language.getId() == programmingLanguage.getId()) {
//				programmingLanguages.set(language.getId() -1, programmingLanguage);
//			}
//		}
//	}
//
//	@Override
//	public List<ProgrammingLanguage> getList() {
//		
//		return programmingLanguages;
//	}
//
//	@Override
//	public ProgrammingLanguage getById(int id) {
//		
//		return programmingLanguages.get(id - 1);
//	}
//}
