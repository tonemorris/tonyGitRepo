package com.tivo.ui.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tivo.ui.domain.Source;


public interface SourceRepository extends PagingAndSortingRepository<Source, String> {
}
