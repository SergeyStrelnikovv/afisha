package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FilmManagerTest {
    @Mock
    private FilmRepository filmRepository;
    @InjectMocks
    FilmManager manager;

    private final Film first = new Film(1, "First film", "Action", "ImageUrl", true);
    private final Film second = new Film(2, "Second film", "Comedy", "ImageUrl", false);
    private final Film third = new Film(3, "Third film", "Drama", "ImageUrl", false);
    private final Film fourth = new Film(4, "Fourth film", "Autobiography", "ImageUrl", false);
    private final Film fifth = new Film(5, "Fifth film", "Horror", "ImageUrl", false);
    private final Film sixth = new Film(6, "Sixth film", "Thriller", "ImageUrl", false);
    private final Film seventh = new Film(7, "Seventh film", "Opera", "ImageUrl", false);
    private final Film eight = new Film(8, "Eighth film", "Cartoon", "ImageUrl", true);
    private final Film ninth = new Film(9, "Ninth film", "Fantasy", "ImageUrl", false);
    private final Film tenth = new Film(10, "Tenth film", "Detective", "ImageUrl", true);
    private final Film eleven = new Film(11, "Eleven film", "Story", "ImageUrl", true);
    private final Film twelve = new Film(12, "Twelve film", "Science fiction", "ImageUrl", false);
    private final Film thirteenth = new Film(13, "Thirteenth film", "Documentary", "ImageUrl", false);
    private final Film fourteenth = new Film(14, "Fourteenth", "Adventure", "ImageUrl", false);
    private final Film fifteenth = new Film(15, "Fifteenth", "Mystic", "ImageUrl", false);

    @BeforeEach
    public void setUp() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eight);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleven);
        manager.addFilm(twelve);
        manager.addFilm(thirteenth);
        manager.addFilm(fourteenth);
        manager.addFilm(fifteenth);
    }

    @Test
    public void shouldGetAll() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth};
        doReturn(returned).when(filmRepository).findAll();
        Film[] expected = new Film[]{first, second, third, fourth, fifth};
        Film[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAll() {
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(filmRepository).findAll();
        // вывод в прямом порядке
        Film[] expected = new Film[]{first, second, third};
        Film[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetNumberedLastAdded() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth, eleven, twelve, thirteenth, fourteenth, fifteenth};
        doReturn(returned).when(filmRepository).findAll();
        Film[] expected = new Film[]{fifteenth, fourteenth, thirteenth, twelve, eleven, tenth, ninth, eight, seventh, sixth};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddFilm() {
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(filmRepository).findAll();
        doNothing().when(filmRepository).save(third);
        manager.addFilm(third);
        Film[] expected = new Film[]{third, second, first};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}