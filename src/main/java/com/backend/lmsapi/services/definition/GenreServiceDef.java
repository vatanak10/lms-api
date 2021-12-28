package com.backend.lmsapi.services.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.lmsapi.dto.GenreDto;
import com.backend.lmsapi.dto.ResponseGenre;
import com.backend.lmsapi.model.Genre;
import com.backend.lmsapi.repositories.GenreRepository;
import com.backend.lmsapi.services.GenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceDef implements GenreService{
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<ResponseGenre> getAllGenre() {
        List<Genre> genres = genreRepository.findAllByStatus("available");
        List<ResponseGenre> responseGenres = new ArrayList<>();
        for (Genre genre: genres){
            responseGenres.add(new ResponseGenre(
                genre.getId(),
                genre.getName(),
                genre.getDescription(),
                genre.getImgUrl(),
                genre.getStatus()
            ));
        }
        return responseGenres;
    }
    
    public ResponseGenre getGenre(String id){
        Optional<Genre> isGenre = genreRepository.findById(id);
        if(!isGenre.isPresent()){
            return null;
        }
        Genre yesGenre = isGenre.get();
        return new ResponseGenre(yesGenre.getId(),yesGenre.getName(),yesGenre.getDescription(),yesGenre.getImgUrl(),yesGenre.getStatus());
        
    }

    @Override
    public Genre addGenre(GenreDto genreDto) {
        Genre genre = new Genre(UUID.randomUUID().toString(), genreDto.getName(),genreDto.getDescription(),genreDto.getImgUrl(),"available");
        return genreRepository.save(genre);
    }

    @Override
    public Genre updateGenre(ResponseGenre responseGenre) {
        Genre genre = new Genre(responseGenre.getId(),responseGenre.getName(),responseGenre.getDescription(),responseGenre.getImgUrl(),responseGenre.getStatus());
        return genreRepository.save(genre);
    }

    @Override
    public String deleteGenre(String id) {
        Optional<Genre> genre = genreRepository.findById(id);
        if(!genre.isPresent()) {
            return "genre cannot found";
        }
        Genre res = genre.get();
        res.setStatus("deleted");
        genreRepository.save(res);
        return res.getStatus();
    }

}
