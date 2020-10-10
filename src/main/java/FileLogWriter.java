import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public final class FileLogWriter implements ILogWriter {

    @Inject
    private @NotNull Logger logger;

    private final String fileName = "src/main/java/MyLogFile.log";
    private final FileHandler fh = new FileHandler(fileName);

    public FileLogWriter() throws IOException {
    }

    @Override
    public void writeLog(int index, String string, String tag) {
        String output = index + ". <" + tag + ">" + string +
                "</" + tag + ">";
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        logger.setUseParentHandlers(false);
        logger.info(output);
    }
}
