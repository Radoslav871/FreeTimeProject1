package com.room001.freetimeproject.repositories;

import com.room001.freetimeproject.models.QuestionImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionImageRepositories extends JpaRepository<QuestionImage,Long> {
    QuestionImage findAllById(long temp);
}
