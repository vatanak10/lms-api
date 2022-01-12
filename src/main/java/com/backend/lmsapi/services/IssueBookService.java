package com.backend.lmsapi.services;

import java.util.List;

import com.backend.lmsapi.dto.IssueBookDto;
import com.backend.lmsapi.model.IssueBook;

public interface IssueBookService {
    List<IssueBook> getAllIssueBook();
    IssueBook getIssueBook(String id);
    IssueBook addIssueBook(IssueBookDto genreDto);
    String deleteIssueBook(String id);
}
