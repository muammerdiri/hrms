package com.muammerdiri.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muammerdiri.hrms.entites.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer>{

}
