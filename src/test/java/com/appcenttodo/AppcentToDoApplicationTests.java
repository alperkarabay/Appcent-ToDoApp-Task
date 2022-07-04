package com.appcenttodo;

import com.appcenttodo.enums.TaskStatus;
import com.appcenttodo.entity.Log;
import com.appcenttodo.entity.Task;
import com.appcenttodo.entity.UserDetail;
import com.appcenttodo.repository.LogRepository;
import com.appcenttodo.repository.TaskRepository;
import com.appcenttodo.repository.UserRepository;
import com.appcenttodo.service.LogServiceImpl;
import com.appcenttodo.service.TaskServiceImpl;
import com.appcenttodo.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TodoAppApplicationTests {
	@InjectMocks
	private TaskServiceImpl taskServiceInject;
	@InjectMocks
	private LogServiceImpl logServiceInject;
	@Mock
	private TaskServiceImpl taskService;
	@Mock
	private LogServiceImpl logService;
	@Mock
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
		Task mockTest = new Task(1,"test task",TaskStatus.TO_DO,1);
		taskService.addTask(mockTest);
		verify(taskService , times(1)).addTask(mockTest);

	}
	@Test
	public void testGetTasks() {

		Task todoTest = new Task();
		todoTest.setTaskTitle("test-name");
		todoTest.setStatus(TaskStatus.TO_DO);
		todoTest.setUserId(0);
		todoTest.setId(1);
		Task todoTest2 = new Task();
		todoTest2.setTaskTitle("test-name 2");
		todoTest2.setStatus(TaskStatus.TO_DO);
		todoTest2.setUserId(1);
		todoTest2.setId(2);
		List<Task> tasks = new ArrayList<>();
		tasks.add(todoTest);


		when(taskRepo.findAllByUserId(0L)).thenReturn(tasks);
		List<Task> todoList =taskServiceInject.getTasks();
		Assertions.assertEquals(1,todoList.size());

	}

	@Test
	public void testDeleteTask() throws Exception {
		Task todoTest = new Task();
		todoTest.setTaskTitle("test-name");
		todoTest.setStatus(TaskStatus.TO_DO);
		todoTest.setUserId(0);
		todoTest.setId(1);
		Task todoTest2 = new Task();
		todoTest2.setTaskTitle("test-name 2");
		todoTest2.setStatus(TaskStatus.TO_DO);
		todoTest2.setUserId(1);
		todoTest2.setId(2);
		taskServiceInject.addTask(todoTest);
		taskServiceInject.addTask(todoTest2);
		taskService.deleteTask(1L);
		verify(taskService, times(1)).deleteTask(1L);

	}

	@Test
	public void testGetAllLogs() {
		Log logTest = new Log();
		logTest.setDescription("test-desc");

		when(logRepo.findAll()).thenReturn(Collections.singletonList(logTest));
		List<Log> logList =logServiceInject.getLogs();
		Assertions.assertEquals(1,logList.size());

	}

	@Test
	public void testUpdateTask() throws Exception {
		Task todoTest = new Task();
		todoTest.setTaskTitle("test-name");
		todoTest.setStatus(TaskStatus.TO_DO);
		todoTest.setUserId(0);
		todoTest.setId(1);
		Task todoTest2 = new Task();
		todoTest2.setTaskTitle("test-name 2");
		todoTest2.setStatus(TaskStatus.TO_DO);
		todoTest2.setUserId(1);
		todoTest2.setId(2);
		Task updatedTask = new Task(1,"updated",TaskStatus.TO_DO,0L);
		taskServiceInject.addTask(todoTest);
		taskServiceInject.addTask(todoTest2);
		taskService.updateTask(1L,updatedTask );
		verify(taskService, times(1)).updateTask(1L,updatedTask);
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