package com.mr.telefonbuch;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TelefonbucheintragController {

	private final TelefonbuchRepository repository;

	private final TelefonbucheintraglAssembler assembler;

	TelefonbucheintragController(TelefonbuchRepository repository, TelefonbucheintraglAssembler assembler) {

		this.repository = repository;
		this.assembler = assembler;
	}

	// Aggregate root

	// tag::get-aggregate-root[]
	@GetMapping("/telefonbuch")
	CollectionModel<EntityModel<Telefonbucheintrag>> all() {

		List<EntityModel<Telefonbucheintrag>> telefonbuch = repository.findAll().stream() //
				.map(assembler::toModel) //
				.collect(Collectors.toList());

		return CollectionModel.of(telefonbuch, linkTo(methodOn(TelefonbucheintragController.class).all()).withSelfRel());
	}
	// end::get-aggregate-root[]

	// tag::post[]
	@PostMapping("/telefonbucheintrag")
	ResponseEntity<?> newTelefonbucheintrag(@RequestBody Telefonbucheintrag newTelefonbucheintrag) {

		EntityModel<Telefonbucheintrag> entityModel = assembler.toModel(repository.save(newTelefonbucheintrag));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}
	// end::post[]

	// Single item

	// tag::get-single-item[]
	@GetMapping("/telefonbucheintrag/{id}")
	EntityModel<Telefonbucheintrag> one(@PathVariable Long id) {

		Telefonbucheintrag telefonbucheintrag = repository.findById(id) //
				.orElseThrow(() -> new TelefonbucheintragNotFoundException(id));

		return assembler.toModel(telefonbucheintrag);
	}
	// end::get-single-item[]

	// tag::put[]
	@PutMapping("/telefonbucheintrag/{id}")
	ResponseEntity<?> replaceTelefonbucheintrag(@RequestBody Telefonbucheintrag newtelefonbucheintrag, @PathVariable Long id) {

		Telefonbucheintrag updatedTelefonbucheintrag = repository.findById(id) //
				.map(telefonbucheintrag -> {
					telefonbucheintrag.setTelefonNr(newtelefonbucheintrag.getTelefonNr());
					telefonbucheintrag.setName(newtelefonbucheintrag.getName());
					telefonbucheintrag.setAdresse(newtelefonbucheintrag.getAdresse());
					return repository.save(telefonbucheintrag);
				}) //
				.orElseGet(() -> {
					newtelefonbucheintrag.setId(id);
					return repository.save(newtelefonbucheintrag);
				});

		EntityModel<Telefonbucheintrag> entityModel = assembler.toModel(updatedTelefonbucheintrag);

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}
	// end::put[]

	// tag::delete[]
	@DeleteMapping("/telefonbucheintrag/{id}")
	ResponseEntity<?> deleteTelefonbucheintrag(@PathVariable Long id) {

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
	// end::delete[]
}
