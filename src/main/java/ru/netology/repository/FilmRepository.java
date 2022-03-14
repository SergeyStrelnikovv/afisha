package ru.netology.repository;

import ru.netology.domain.Film;

public class FilmRepository {
    private Film[] films = new Film[0];

    public Film[] findAll() {
        return films;
    }

    public void save(Film film)
    {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int newFilm = tmp.length - 1;
        tmp[newFilm] = film;
        this.films = tmp;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film item : films) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        films = tmp;
    }

    public Film findById(int id) {
        for (Film item : films) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeAll() {
        films = new Film[0];
    }
}