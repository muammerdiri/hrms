package com.muammerdiri.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muammerdiri.hrms.business.abstracts.LanguageService;
import com.muammerdiri.hrms.dataAccess.abstracts.LanguageRepository;
import com.muammerdiri.hrms.entites.concretes.Language;
@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	   @Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}
	
	@Override
	public Language findById(int id) {
		Optional<Language> foundLanguage =languageRepository.findById(id);
		Language language = foundLanguage.get();
		return  language;
	}
}
