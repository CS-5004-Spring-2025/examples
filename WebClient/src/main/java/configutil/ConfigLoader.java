package configutil;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;

public class ConfigLoader {

    public static Config loadConfig() {
        // The ObjectMapper helps with reading/writing JSON.
        ObjectMapper mapper = new ObjectMapper();
        try {
            Config config = mapper.readValue(new File(".config"), Config.class);
            return config;
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return null;
    }

}
