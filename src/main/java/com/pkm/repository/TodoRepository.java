/**
 * 
 */
package com.pkm.repository;

import org.springframework.data.repository.CrudRepository;

import com.pkm.entity.Todo;

/**
 * @author pkumar
 *
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {
	
	Todo findOneByDescription(String description);

}
