package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.TranslationService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TranslatorController {

	@Autowired
	TranslationService translationService;
	
	
	@RequestMapping(value="/translate", produces = "text/html; charset=UTF-8")
	public @ResponseBody String translate(@RequestParam(value="message") String input, @RequestParam(value="toLang") String targetLang, @RequestParam(value="callback") String callback){
		return callback+"({text:\""+translationService.translate(input, targetLang)+"\"})";
	}
	
	@RequestMapping(value="/langs", produces = "text/html; charset=UTF-8")
	public @ResponseBody String getSupportedLanguages(@RequestParam(value="callback") String callback) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String languageList = mapper.writeValueAsString(translationService.getSupportedLanguages());
		return callback+"("+ languageList +")";
	}
	
}
