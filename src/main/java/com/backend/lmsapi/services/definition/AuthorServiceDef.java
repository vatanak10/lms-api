package com.backend.lmsapi.services.definition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.lmsapi.dto.AuthorDto;
import com.backend.lmsapi.dto.ResponseAuthor;
import com.backend.lmsapi.model.Author;
import com.backend.lmsapi.repositories.AuthorRepository;
import com.backend.lmsapi.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AuthorServiceDef implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public List<ResponseAuthor> getAllAuthor() {
        List<Author> authors = authorRepository.findAllByStatus("available");
        List<ResponseAuthor> responseAuthors = new ArrayList<>();
        for (Author author: authors){
            responseAuthors.add(new ResponseAuthor(
                author.getId(),
                author.getName(),
                author.getBiography(),
                author.getImgUrl(),
                author.getStatus()
            ));
        }
        return responseAuthors;
    }
    
    public ResponseAuthor getAuthor(String id){
        Optional<Author> isAuthor = authorRepository.findById(id);
        if(!isAuthor.isPresent()){
            return null;
        }
        Author yesAuthor = isAuthor.get();
        return new ResponseAuthor(yesAuthor.getId(),yesAuthor.getName(),yesAuthor.getBiography(),yesAuthor.getImgUrl(),yesAuthor.getStatus());
        
    }

    @Override
    public Author addAuthor(AuthorDto authorDto) {
        // TODO Auto-generated method stub
        Author author = new Author(UUID.randomUUID().toString(), authorDto.getName(),authorDto.getBiography(),authorDto.getImgUrl(),"available");
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(ResponseAuthor responseAuthor) {
        // TODO Auto-generated method stub
        Author author = new Author(responseAuthor.getId(),responseAuthor.getName(),responseAuthor.getBiography(),responseAuthor.getImgUrl(),responseAuthor.getStatus());
        return authorRepository.save(author);
    }

    @Override
    public String deleteAuthor(String id) {
        Optional<Author> author = authorRepository.findById(id);
        if(!author.isPresent()) {
            return "author cannot found";
        }
        Author res = author.get();
        res.setStatus("deleted");
        authorRepository.save(res);
        return res.getStatus();
    }

    
}
