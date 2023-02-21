package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileExample1 {
    public static void main(String[] args) throws Exception {
//        Files.list(Paths.get(".")).forEach(System.out::println);

        Path currentPath = Paths.get("./resources/data.txt");
        Path newFilePath = Paths.get("./resources/newData.txt");

        Files.walk(currentPath, 2)
                .filter(item -> String.valueOf(item)
                        .endsWith(".java"))
                .forEach(System.out::println);
        // 파일을 스트림 처리하여
        List<String> dataTxtResult = Files.lines(currentPath).collect(Collectors.toList());
        Files.write(newFilePath, dataTxtResult);
    }
}
