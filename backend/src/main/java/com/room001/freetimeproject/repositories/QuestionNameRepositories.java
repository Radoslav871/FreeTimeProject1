package com.room001.freetimeproject.repositories;

import com.room001.freetimeproject.models.QuestionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionNameRepositories extends JpaRepository<QuestionName,Long> {
}
