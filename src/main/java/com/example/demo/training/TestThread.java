package com.example.demo.training;


import java.io.*;
import java.net.Socket;

public class TestThread extends Thread {

    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;
    private Employee employee;

    public TestThread(Socket socket, Agenda agenda) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        employee = new Employee();
        employee.setAgenda(agenda);
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!reader.readLine().equals("")) {
                    break;
                };
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        writer.flush();
        writer.close();
    }
}