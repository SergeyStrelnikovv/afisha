package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

public class FilmManager {
    private FilmRepository repository;
    Film[] films = new Film[0];
    int filmsQuantity = 10;

    public FilmManager() {
    }

    public FilmManager(FilmRepository repository, int filmsQuantity) {
        this.repository = repository;
    }

    public void addFilm(Film film) {
        repository.save(film);
    }

    public Film[] getAll() {
        Film[] films = repository.findAll();
        int resultLength = Math.min(filmsQuantity, films.length);
        Film[] result = new Film[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] showAll() {
        return repository.findAll();
    }
}