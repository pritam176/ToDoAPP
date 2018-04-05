/**
 * 
 */
package com.pkm.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pkm.entity.Todo;
import com.pkm.repository.TodoRepository;

/**
 * @author pkumar
 *
 */
@Component
public class CommandLineRunnerCustome implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(CommandLineRunnerCustome.class);
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public void run(String... arg0) throws Exception {
		this.logger.info("COMMAND LINE RUNNER");
		this.logger.info(this.todoRepository.save(new Todo("first todo","first name")).toString());
		this.logger.info(this.todoRepository.save(new Todo("second todo","second name")).toString());
		this.logger.info(this.todoRepository.save(new Todo("third todo","third name")).toString());

	}

}
