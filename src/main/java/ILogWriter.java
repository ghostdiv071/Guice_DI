import java.io.IOException;

public interface ILogWriter {

    void writeLog(int index, String string, String tag) throws IOException;
}
