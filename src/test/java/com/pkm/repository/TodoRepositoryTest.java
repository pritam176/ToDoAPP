/**
 * 
 */
package com.pkm.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.pkm.config.ToDoAppApplication;
import com.pkm.entity.Todo;


/**
 * @author pkumar
 *
 */
@SpringBootTest(classes = ToDoAppApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class TodoRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TodoRepository todoRepository;

	private Todo firstTodo;
	private Todo secondTodo;
	
	@Before
	public void before() {
		this.firstTodo = new Todo("First Todo","First Name");
		this.entityManager.persist(this.firstTodo);
		this.secondTodo = new Todo("Second Todo","Second Todo");
		this.entityManager.persist(this.secondTodo);
	}
	
	@Test
	public void findAllTodos() {
		final List<Todo> todos = (List<Todo>) this.todoRepository.findAll();

		assertThat(todos.size()).isEqualTo(5);
	}

	@Test
	public void findOneTodo() {
		assertThat(this.todoRepository.findOneByDescription(this.firstTodo.getDescription())).isEqualTo(this.firstTodo);
	}

	@Test
	public void addNewTodo() {
		final Todo newTodo = new Todo("My New Todo","New Todo");
		this.todoRepository.save(newTodo);
		final Todo newTodoFromDb = this.todoRepository.findOneByDescription(newTodo.getDescription());
		assertThat(newTodo).isEqualTo(newTodoFromDb);
	}

	@Test
	public void updateExistingTodo(){
		this.firstTodo.setDescription("Updated First Todo");
		this.todoRepository.save(this.firstTodo);
		assertThat(this.todoRepository.findOneByDescription("Updated First Todo")).isNotNull();
	}

	@Test
	public void deleteTodo() {
		this.todoRepository.delete(this.firstTodo);
		assertThat(this.todoRepository.findOneByDescription(this.firstTodo.getDescription())).isNull();
	}

}
