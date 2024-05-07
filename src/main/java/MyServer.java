
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


    public static void main(String[] args) {
        MyServer server = new MyServer();
        server.start(DEFAULT_PORT);
    }


    public void start(int port) {
        this.javalin.start(port);
    }


    public void stop() {
        this.javalin.close();
        this.javalin.stop();
    }
}
