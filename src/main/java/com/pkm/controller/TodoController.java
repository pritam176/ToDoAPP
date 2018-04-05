/**
 * 
 */
package com.pkm.controller;

import java.util.List;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
>>>>>>> fd4f67170f4eb20e85fc75c9943623c1f62b77fe
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.pkm.config.CommandLineRunnerCustome;
=======
>>>>>>> fd4f67170f4eb20e85fc75c9943623c1f62b77fe
import com.pkm.entity.Todo;
import com.pkm.repository.TodoRepository;

/**
 * @author pkumar
 *
 */
@RestController
@RequestMapping("todos")
public class TodoController {
<<<<<<< HEAD
	
	private final Logger logger = LoggerFactory.getLogger(CommandLineRunnerCustome.class);
=======
>>>>>>> fd4f67170f4eb20e85fc75c9943623c1f62b77fe

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping
	public List<Todo> getAllTodos() {
<<<<<<< HEAD
		logger.debug("getAllTodos");
=======
>>>>>>> fd4f67170f4eb20e85fc75c9943623c1f62b77fe
		return (List<Todo>) this.todoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable("id") final Todo todo) {
<<<<<<< HEAD
		logger.debug("getTodo id-"+todo.getId());
=======
>>>>>>> fd4f67170f4eb20e85fc75c9943623c1f62b77fe
		return todo;
	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable("id") final Long id, @RequestBody final Todo todo) {
<<<<<<< HEAD
		logger.debug("updateTodo id-"+todo.getId());
=======
>>>>>>> fd4f67170f4eb20e85fc75c9943623c1f62b77fe
		todo.setId(id);
		return this.todoRepository.save(todo);
	}

	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable("id") final Long id) {
<<<<<<< HEAD
		logger.debug("deleteTodo id-"+id);
=======
>>>>>>> fd4f67170f4eb20e85fc75c9943623c1f62b77fe
		this.todoRepository.delete(id);
	}
	
	@PostMapping
	public Todo addTodo(@RequestBody final Todo todo) {
<<<<<<< HEAD
		logger.debug("addTodo id-"+todo.getName());
=======
		
>>>>>>> fd4f67170f4eb20e85fc75c9943623c1f62b77fe
		final Todo newTodo = this.todoRepository.save(todo);

		/*final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newTodo.getId()).toUri();*/

		return newTodo;
	}

}
