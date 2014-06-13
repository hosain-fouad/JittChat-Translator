package model;

public class SuppertedLanguage {

	private String languageCode;
	private String languageValue;
	
	public SuppertedLanguage(String languageCode, String languageValue) {
		this.languageCode = languageCode;
		this.languageValue = languageValue;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public String getLanguageValue() {
		return languageValue;
	}
}
