package com.t3f.service;

import com.t3f.model.MultiChoiceQuestion;
import com.t3f.model.Translation;
import com.t3f.repository.TranslationRepository;
import com.t3f.utility.RandomSampler;

import java.util.List;

public class QuestionService {

    private TranslationRepository translationRepository;

    public QuestionService(TranslationRepository translationRepository){
        this.translationRepository = translationRepository;
    }

    public MultiChoiceQuestion generateRandomQuestion(){

        List<Translation> translations = translationRepository.getTranslations();
        List<Translation> translationsSelected = new RandomSampler().selectRandomSample(translations, 3);

        MultiChoiceQuestion question = new MultiChoiceQuestion(
            translationsSelected.get(0).getGerman(),
            translationsSelected.get(0).getEnglish(),
            new String[]{
                    translationsSelected.get(1).getEnglish(),
                    translationsSelected.get(2).getEnglish()
            }
        );

        return question;
    }

}
