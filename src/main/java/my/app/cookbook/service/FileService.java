package my.app.cookbook.service;

public interface FileService {
    boolean writeToFile(String json, String fileName);
    String readFromFile(String fileName);
    boolean cleanFile(String fileName);
}
