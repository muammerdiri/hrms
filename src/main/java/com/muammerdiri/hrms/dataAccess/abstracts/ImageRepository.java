package com.muammerdiri.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muammerdiri.hrms.entites.concretes.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
