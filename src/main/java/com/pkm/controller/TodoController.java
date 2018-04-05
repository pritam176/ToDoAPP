/**
 * 
 */
package com.pkm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkm.entity.Todo;
import com.pkm.repository.TodoRepository;

/**
 * @author pkumar
 *
 */
@RestController
@RequestMapping("todos")
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping
	public List<Todo> getAllTodos() {
		return (List<Todo>) this.todoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable("id") final Todo todo) {
		return todo;
	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable("id") final Long id, @RequestBody final Todo todo) {
		todo.setId(id);
		return this.todoRepository.save(todo);
	}

	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable("id") final Long id) {
		this.todoRepository.delete(id);
	}
	
	@PostMapping
	public Todo addTodo(@RequestBody final Todo todo) {
		
		final Todo newTodo = this.todoRepository.save(todo);

		/*final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newTodo.getId()).toUri();*/

		return newTodo;
	}

}
