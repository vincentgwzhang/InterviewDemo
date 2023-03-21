package com.company.controller.rest;

import com.company.dto.DemoDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class DemoRepresentationModelAssembler implements SimpleRepresentationModelAssembler<DemoDTO> {

    @Override
    public void addLinks(EntityModel<DemoDTO> resource) {
        Link linkSelf = linkTo(methodOn(DemoController.class).getEntityById(resource.getContent().getStr1())).withSelfRel();
        Link linkTotal = linkTo(methodOn(DemoController.class).getAllDemoEntities()).withSelfRel().withRel("all");

        resource.add(linkSelf);
        resource.add(linkTotal);
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<DemoDTO>> resources) {
        Link link1 = Link.of("https://www.google.com", "google");
        Link link2 = Link.of("https://www.microsoft.com", "microsoft");

        resources.add(link1);
        resources.add(link2);
    }
}
