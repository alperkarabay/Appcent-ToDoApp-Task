package com.appcenttodo;

import com.appcenttodo.enums.TaskStatus;
import com.appcenttodo.models.Log;
import com.appcenttodo.models.Task;
import com.appcenttodo.models.UserDetail;
import com.appcenttodo.repositories.LogRepository;
import com.appcenttodo.repositories.TaskRepository;
import com.appcenttodo.repositories.UserRepository;
import com.appcenttodo.services.LogServiceImpl;
import com.appcenttodo.services.TaskService;
import com.appcenttodo.services.TaskServiceImpl;
import com.appcenttodo.services.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TodoAppApplicationTests {

	@InjectMocks
	private TaskServiceImpl taskService;
	@InjectMocks
	private LogServiceImpl logService;
	@InjectMocks
	private UserServiceImpl userService;
	@Mock
	private Task task;
	@Mock
	private Log log;
	@Mock
	private UserDetail user;


	@Mock
	private LogRepository logRepo;
	@Mock
	private TaskRepository taskRepo;
	@Mock
	private UserRepository userRepo;
	@Mock
	private UserServiceImpl uService;
	@Test
	public void testAddTask() throws Exception {

	}
	@Test
	public void testGetTaks() {

		Task todoTest = new Task();
		todoTest.setTaskTitle("test-name");
		todoTest.setStatus(TaskStatus.TO_DO);
		todoTest.setUserId(1);
		todoTest.setId(1);
		Task todoTest2 = new Task();
		todoTest2.setTaskTitle("test-name 2");
		todoTest2.setStatus(TaskStatus.TO_DO);
		todoTest2.setUserId(2);
		todoTest2.setId(2);
		List<Task> tasks = new ArrayList<>();
		tasks.add(todoTest);


		when(taskRepo.findAllByUserId(1)).thenReturn(tasks);
		when(uService.getCurrentUserId()).thenReturn(1L);
		List<Task> todoList =taskService.getTasks();
		Assertions.assertEquals(1,todoList.size());

	}

	/*@Test
	public void testDeleteTask() throws Exception {
		Task todoTest = new Task();
		todoTest.setTaskTitle("test-name");
		todoTest.setStatus(TaskStatus.TO_DO);
		todoTest.setUserId(1);
		todoTest.setId(1);
		Task todoTest2 = new Task();
		todoTest2.setTaskTitle("test-name 2");
		todoTest2.setStatus(TaskStatus.TO_DO);
		todoTest2.setUserId(2);
		todoTest2.setId(2);
		List<Task> tasks = new ArrayList<>();
		tasks.add(todoTest);
		List<Task> todoList =taskService.getTasks();
		when(taskRepo.deleteById(1L)).thenReturn(taskRepo.deleteById(1L));
		when(uService.getCurrentUserId()).thenReturn(1L);
		taskService.deleteTask(1L);
		verify(taskRepo, times(1)).deleteById(1L);
	//	Task taskToDelete = taskRepo.findById(1L).orElseThrow(() -> new Exception("Task not found with id : "+ todoTest.getId()));

	//	Assertions.assertEquals(null,taskToDelete);
	}*/

	@Test
	public void testGetAllLogs() {
		Log logTest = new Log();
		logTest.setDescription("test-desc");

		when(logRepo.findAll()).thenReturn(Collections.singletonList(logTest));
		List<Log> logList =logService.getLogs();
		Assertions.assertEquals(1,logList.size());

	}

	@Test
	public void testUpdateTask() {
	}
	@Test
	public void register() {
		UserDetail registerTest = new UserDetail();
		registerTest.setUsername("test-name");
		registerTest.setPassword("password");
		userService.register(registerTest);
		Assertions.assertEquals(false,userRepo.findById(1L).isPresent());

	}
}