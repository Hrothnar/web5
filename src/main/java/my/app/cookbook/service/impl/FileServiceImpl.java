package my.app.cookbook.service.impl;

import my.app.cookbook.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceImpl implements FileService {
    @Value("${files.path}")
    private String filePath;

    @Override
    public boolean writeToFile(String json, String fileName) {
        try {
            cleanFile(fileName);
            Files.writeString(Path.of(filePath, fileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String readFromFile(String fileName) {
        try {
            return Files.readString(Path.of(filePath, fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanFile(String fileName) {
        Path path = Path.of(filePath, fileName);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
