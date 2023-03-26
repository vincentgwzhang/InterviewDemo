package com.company.dto;

import lombok.Data;
import org.apache.commons.collections4.map.HashedMap;

import java.util.Map;

@Data
public class CatalogDTO {

    private int id;

    private String code;

    private String imageUrl;

    /**
     * Map<catalog_code, Map<language_code, language>>
     */
    private Map<String, Map<String, String>> languages = new HashedMap<>();

}
