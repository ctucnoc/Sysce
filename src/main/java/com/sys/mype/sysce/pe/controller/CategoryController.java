package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.CategoryDTO;
import com.sys.mype.sysce.pe.dto.request.CategoryRequestDTO;
import com.sys.mype.sysce.pe.service.CategoryService;
import com.sys.mype.sysce.pe.util.CRUD;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SysceConstant.RESOURCE_CATEGORYS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class CategoryController extends GenericController {

	final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping(SysceConstant.RESOURCE_CATEGORYS_CATEGORY)
	public ResponseEntity<?> save(@Valid @RequestBody CategoryRequestDTO categoryDTO) {
		return super.ok(this.categoryService.save(categoryDTO), CRUD.REGISTER);
	}

	@GetMapping(SysceConstant.RESOURCE_CATEGORYS_CATEGORY + "/{id}")
	public ResponseEntity<?> save(@PathVariable int id) {
		return super.ok(this.categoryService.findById(id), CRUD.FIND);
	}

	@GetMapping(SysceConstant.RESOURCE_CATEGORYS_CATEGORY)
	public ResponseEntity<?> findByDescription(@RequestParam String key_word) {
		return super.ok(this.categoryService.findByDescription(key_word), CRUD.FIND);
	}

	@PutMapping(SysceConstant.RESOURCE_CATEGORYS_CATEGORY + "/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody CategoryDTO dto, @PathVariable int id) {
		return super.ok(this.categoryService.update(dto, id), CRUD.FIND);
	}
}
