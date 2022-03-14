package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Film {
    private int id;
    private String filmName;
    private String filmGenre;
    private String ImageUrl;
    private boolean tomorrowPremiere;
}
