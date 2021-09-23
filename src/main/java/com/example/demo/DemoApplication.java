package com.example.demo;

import com.example.demo.training.Agenda;
import com.example.demo.training.Task;
import com.example.demo.training.TestThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		List<Task> tasks = new Task().makeTasks();
		new Task().effective();

		Agenda agenda = new Agenda();
		agenda.setTasks(tasks);

		try {
			ServerSocket serverSocket = new ServerSocket(80, 5);
			while (true){
				Socket socket = serverSocket.accept();
				new Thread(new TestThread(socket,agenda)).start();
			}

		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
