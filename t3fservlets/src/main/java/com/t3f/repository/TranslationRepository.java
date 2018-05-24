package com.t3f.repository;

import com.google.gson.Gson;
import com.t3f.model.Translation;
import com.t3f.utility.ResourceReader;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class TranslationRepository {

    private Translation[] translations;

    public TranslationRepository(){
        String content = new ResourceReader().read("GermanWords1000.json", StandardCharsets.UTF_8);
        translations = new Gson().fromJson(content, Translation[].class);
    }

    public List<Translation> getTranslations() {
        return Arrays.asList(translations) ;
    }

}
