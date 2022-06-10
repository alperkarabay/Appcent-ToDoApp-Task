package com.appcenttodo;

import com.appcenttodo.enums.TaskStatus;
import com.appcenttodo.models.Task;
import com.appcenttodo.repositories.TaskRepository;
import com.appcenttodo.services.LogServiceImpl;
import com.appcenttodo.services.TaskService;
import com.appcenttodo.services.TaskServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Collections;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TodoAppApplicationTests {

	@InjectMocks
	private TaskServiceImpl taskService;

	@InjectMocks
	private LogServiceImpl logService;
	@Mock
	private Task task;
	@Mock
	private TaskRepository taskRepo;

	@Test
	public void testAddTask() throws Exception {

	}
	@Test
	public void testGetAllTasks() {
		Task todoTest = new Task();
		todoTest.setTaskTitle("test-name");
		todoTest.setStatus(TaskStatus.TO_DO);
		todoTest.setId(1);

		when(taskRepo.findAll()).thenReturn(Collections.singletonList(todoTest));
		List<Task> todoList =taskService.getTasks();
		Assertions.assertEquals(1,todoList.size());

	}

	@Test
	public void testGetAllTasksWithNoData() {
		Task taskTest = new Task();
		taskTest.setTaskTitle("New Task");
		taskTest.setStatus(TaskStatus.TO_DO);
		taskTest.setId(1);
		when(taskRepo.findAll()).thenReturn(Collections.emptyList(),Collections.singletonList(taskTest));
		taskService.addTask(taskTest);
		List<Task> todoList =taskService.getTasks();
		Assertions.assertEquals(1,todoList.size());
		Assertions.assertEquals(todoList.get(0),Task.builder().id(1).taskTitle("test").build());
	}

	@Test
	public void testUpdateTask() {
	}

}