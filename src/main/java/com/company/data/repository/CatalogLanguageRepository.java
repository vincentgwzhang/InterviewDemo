package com.company.data.repository;

import com.company.data.entity.CatalogLanguage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogLanguageRepository extends CrudRepository<CatalogLanguage, Integer> {
}
