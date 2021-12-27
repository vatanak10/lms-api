package com.backend.lmsapi.services;

import java.util.List;

import com.backend.lmsapi.dto.GenreDto;
import com.backend.lmsapi.dto.ResponseGenre;
import com.backend.lmsapi.model.Genre;

public interface GenreService {
    List<ResponseGenre> getAllGenre();
    ResponseGenre getGenre(String id);
    Genre addGenre(GenreDto genreDto);
    Genre updateGenre(ResponseGenre responseGenre);
    String deleteGenre(String id);
}
