package me.lapingcao.cat_api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {
    private final CatRepository repository;
    private final CatModelAssembler assembler;

    CatController(CatRepository repository, CatModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/cats")
    CollectionModel<EntityModel<Cat>> all() {
        List<EntityModel<Cat>> cats = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(cats, linkTo(methodOn(CatController.class).all()).withSelfRel()); 
    }

    @GetMapping("/cats/{id}")
    EntityModel<Cat> one(@PathVariable Long id) {
        Cat cat = repository.findById(id).orElseThrow(() -> new CatNotFoundException(id));
        return assembler.toModel(cat);
    }
}