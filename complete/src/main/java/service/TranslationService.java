package service;

import java.util.ArrayList;
import java.util.List;

import model.SuppertedLanguage;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class TranslationService {
	
	private List<SuppertedLanguage> supportedLanguages;
	
	public TranslationService() {
		this.supportedLanguages = new ArrayList<SuppertedLanguage>();
		for(Language language: Language.values()){
			this.supportedLanguages.add(new SuppertedLanguage(language.name(), translate(language.name(),language.name())));
		}
	}

	public String translate(String input,String targetLang){

	    String translatedText = null;
	    try {
	    	
			translatedText = Translate.execute(input, Language.AUTO_DETECT, Language.fromString(Language.valueOf(targetLang).toString()));
			
		    if (translatedText.contains("ArgumentOutOfRangeException")) {
				translatedText=input;
			}
		} catch (Exception e) {
			System.err.println("problems happened during translation, may be from bing online service! \n");
			e.printStackTrace();
		}

	    return translatedText;
	}

	public List<SuppertedLanguage> getSupportedLanguages(){
		return this.supportedLanguages;
	}

}
