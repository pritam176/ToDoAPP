/**
 * 
 */
package com.pkm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkm.config.CommandLineRunnerCustome;

import com.pkm.entity.Todo;
import com.pkm.repository.TodoRepository;

/**
 * @author pkumar
 *
 */
@RestController
@RequestMapping("todos")
public class TodoController {

	private final Logger logger = LoggerFactory.getLogger(CommandLineRunnerCustome.class);

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping
	public List<Todo> getAllTodos() {

		logger.debug("getAllTodos");

		return (List<Todo>) this.todoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable("id") final Todo todo) {

		logger.debug("getTodo id-" + todo.getId());

		return todo;
	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable("id") final Long id, @RequestBody final Todo todo) {

		logger.debug("updateTodo id-" + todo.getId());

		todo.setId(id);
		return this.todoRepository.save(todo);
	}

	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable("id") final Long id) {

		logger.debug("deleteTodo id-" + id);

		this.todoRepository.delete(id);
	}

	@PostMapping
	public Todo addTodo(@RequestBody final Todo todo) {

		logger.debug("addTodo id-" + todo.getName());

		final Todo newTodo = this.todoRepository.save(todo);

		/*
		 * final URI location =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		 * .buildAndExpand(newTodo.getId()).toUri();
		 */

		return newTodo;
	}

}
