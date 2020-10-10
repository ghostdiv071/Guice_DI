import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public final class ConsoleLogWriter implements ILogWriter {

    @Inject
    private @NotNull Logger logger;

    @Override
    public void writeLog(int index, String string, String tag) {
        String output = index + ". <" + tag + ">" + string +
                "</" + tag + ">";
        logger.info(output);
    }
}
