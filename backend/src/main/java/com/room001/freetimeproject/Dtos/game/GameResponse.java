package com.room001.freetimeproject.Dtos.game;

import com.room001.freetimeproject.models.QuestionImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameResponse {

    private List<QuestionImage> questionImages;

}
