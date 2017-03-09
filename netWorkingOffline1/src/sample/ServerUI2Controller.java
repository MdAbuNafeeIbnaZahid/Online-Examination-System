package sample;

/**
 * Created by nafee on 3/9/17.
 */
public class ServerUI2Controller
{

    public static Server server;
    public static ServerStarter serverStarter;

    public static Server getServer() {
        return server;
    }

    public static void setServer(Server server) {
        ServerUI2Controller.server = server;
    }

    public ServerStarter getServerStarter() {
        return serverStarter;
    }

    public static void setServerStarter(ServerStarter serverStarter) {
        ServerUI2Controller.serverStarter = serverStarter;
    }

}
