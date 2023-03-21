package com.company.controller.rest;

import com.company.dto.DemoDTO;
import com.company.system.exceptions.ProductNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("test")
@AllArgsConstructor
public class DemoController {

    private final DemoRepresentationModelAssembler assembler;

    @GetMapping("testException")
    public void testException() {
        throw new ProductNotFoundException(10000);
    }

    @GetMapping("entities")
    public CollectionModel<EntityModel<DemoDTO>> getAllDemoEntities() {
        List<DemoDTO> demoDTOList = List.of(
                new DemoDTO("str 1", new Date(), 23, 34.32d),
                new DemoDTO("str 2", new Date(), 24, 62.17d));

        return assembler.toCollectionModel(demoDTOList);
    }

    @GetMapping("entities/{str}")
    public EntityModel<DemoDTO> getEntityById(@PathVariable String str) {
        DemoDTO demo = new DemoDTO(str, new Date(), 23, 34.32d);
        return assembler.toModel(demo);
    }
}
