package com.mr.telefonbuch;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class TelefonbucheintraglAssembler implements RepresentationModelAssembler<Telefonbucheintrag, EntityModel<Telefonbucheintrag>> {

	@Override
	public EntityModel<Telefonbucheintrag> toModel(Telefonbucheintrag telefonbuch) {

		return EntityModel.of(telefonbuch, //
				linkTo(methodOn(TelefonbucheintragController.class).one(telefonbuch.getId())).withSelfRel(),
				linkTo(methodOn(TelefonbucheintragController.class).all()).withRel("telefonbuch"));
	}
}
