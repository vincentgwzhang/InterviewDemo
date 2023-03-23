package com.company.service;

import com.company.dto.CatalogDTO;

import java.util.List;

public interface CatalogService {

    CatalogDTO getCatalogInforById(int id);

    List<CatalogDTO> getCatalogsInfor();

    void createCatalog(CatalogDTO catalogDTO);

    void deleteCatalog(int id, boolean force);

    void updateCatalog(CatalogDTO catalogDTO);

}
