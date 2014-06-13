package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import service.TranslationService;

import com.memetix.mst.translate.Translate;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public TranslationService translationService(){
	    Translate.setClientId("hosainhosainhosain");
	    Translate.setClientSecret("iHZ3RktAd8CbnqflIpRNcLNuH2kom7Cv2o90FkGDv5M=");
	    return new TranslationService();
    }

}
