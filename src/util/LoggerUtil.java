package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerUtil {

    private static final String FILE_NAME = "erros.txt";

    public static void logError(String mensagem) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(LocalDateTime.now() + " - " + mensagem + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de log.");
        }
    }
}