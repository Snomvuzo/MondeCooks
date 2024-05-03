
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class MyServer {
    private static final String PAGES_DIR = "/html";
    private static final int DEFAULT_PORT = 5000;
    private final Javalin javalin;
    
    
    public MyServer() {
        this.javalin = Javalin.create(config -> {
            config.addStaticFiles(PAGES_DIR, Location.CLASSPATH);
        });
    }

    /**
     * Run the server for manual testing
     * @param args ignored, no command line args
     */
    public static void main(String[] args) {
        MyServer server = new MyServer();
        server.start(DEFAULT_PORT);
    }

    /**
     * Start the server
     * @param port the port on which to start the server
     */
    public void start(int port) {
        this.javalin.start(port);
    }

    /**
     * Stop the server
     */
    public void stop() {
        this.javalin.close();
        this.javalin.stop();
    }
}
