import com.google.inject.AbstractModule;

public final class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ILogWriter.class).to(ConsoleLogWriter.class);
        bind(ILogWriter.class).annotatedWith(MyAnn.class).to(FileLogWriter.class);
    }
}
