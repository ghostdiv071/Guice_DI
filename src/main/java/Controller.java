import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public final class Controller {

    private final @NotNull ILogWriter consoleLogWriter, fileLogWriter;
    private final TreeSet<Integer> indices = new TreeSet<>();

    @Inject
    public Controller(@NotNull ILogWriter consoleLogWriter, @NotNull @MyAnn ILogWriter fileLogWriter) {
        this.consoleLogWriter = consoleLogWriter;
        this.fileLogWriter = fileLogWriter;
    }

    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Write your string: ");
                String string = scanner.next();

                System.out.print("Write tag for logging: ");
                String tag = scanner.next();

                System.out.print("Choose logging method:\n1 - console output" +
                        "\n2 - writing to file" +
                        "\n3 - composite logging\n0 - exit\n");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        consoleLogWriter.writeLog(getIndex() ,string, tag);
                        break;
                    case 2:
                        fileLogWriter.writeLog(getIndex(), string, tag);
                        break;
                    case 3:
                        consoleLogWriter.writeLog(getIndex() ,string, tag);
                        fileLogWriter.writeLog(getIndex(), string, tag);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Try again.");
                        waitForInput();
                }

            }
        } catch (IllegalStateException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private int getIndex() {
        int index;
        if (indices.isEmpty()) {
            index = 1;
        } else {
            index = indices.last() + 1;
        }
        indices.add(index);
        return index;
    }
}
