package ar.edu.unq.circuito.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import org.springframework.core.io.ClassPathResource;

public class ConversorDeArchivos {

    public static String convertirABase64(String path) {
        File imgfile;
        String pic = "";
        try {
            imgfile = new ClassPathResource(path).getFile();
            pic = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(imgfile.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "data:image/jpeg;base64," + pic;
    }

}
