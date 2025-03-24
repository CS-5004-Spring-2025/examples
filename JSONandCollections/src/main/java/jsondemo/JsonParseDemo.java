package jsondemo;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jsondemo.data.Book;
import jsondemo.data.Task;

public class JsonParseDemo {

    public static void readWriteBook() {
        // The ObjectMapper helps with reading/writing JSON.
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Book is a plain old java object (POJO).
            // mapper will create an instance of book from a json file.
            Book book = mapper.readValue(new File("resources/book.json"), Book.class);

            System.out.println(book.toString());
            book.setAuthor("Octavia E. Butler");

            // Now, save the new version to a file using the mapper.
            mapper.writeValue(new File("resources/book.out.json"), book);
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void parseTaskList() {
        List<Task> listoftasks = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(new File("resources/listoftasks.json"));
            for (JsonNode taskNode : root.get("listoftasks")) {
                Task t = new Task(
                        taskNode.get("description").asText(),
                        LocalDate.parse(taskNode.get("deadline").asText()));
                listoftasks.add(t);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        for (Task task : listoftasks) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {
//        readWriteBook();
        parseTaskList();
    }


}
