package com.company.service.impl;

import com.company.dto.CatalogDTO;
import com.company.service.CatalogService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatalogServiceImpl implements CatalogService {
    @Override
    public CatalogDTO getCatalogInforById(int id) {
        return null;
    }

    @Override
    public List<CatalogDTO> getCatalogsInfor() {
        return null;
    }

    @Override
    public void createCatalog(CatalogDTO catalogDTO) {

    }

    @Override
    public void deleteCatalog(int id, boolean force) {

    }

    @Override
    public void updateCatalog(CatalogDTO catalogDTO) {

    }
}
