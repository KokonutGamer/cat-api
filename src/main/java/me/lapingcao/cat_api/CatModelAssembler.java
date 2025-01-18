package me.lapingcao.cat_api;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CatModelAssembler implements RepresentationModelAssembler<Cat, EntityModel<Cat>> {

    @Override
    public EntityModel<Cat> toModel(Cat cat) {
        return EntityModel.of(
            cat,
            linkTo(methodOn(CatController.class).one(cat.getId())).withSelfRel(),
            linkTo(methodOn(CatController.class).all()).withRel("cats"));
    }

}