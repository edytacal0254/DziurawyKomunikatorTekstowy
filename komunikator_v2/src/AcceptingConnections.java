import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.SocketException;

public class AcceptingConnections extends Thread {
    private Server server;
    private boolean running;

    public AcceptingConnections(Server s) {
        this.setServer(s);
        this.setRunning(true);
    }

    @Override
    public void run() {
        try {
            while (isRunning()) {
                try {

                    //ToDo.2.1

                    System.out.println("Accepted new connection");

                    //
                    //
                    //
                    //

                    getServer().getClientHandlersHM().put(getServer().getClientNr(), cH); // add this client to active clients list

                    t.start(); //uruchom wątek

                    System.out.println("Client nr.: " + getServer().getClientNr() + " joined server.");
                    getServer().setClientNr(getServer().getClientNr() + 1);
                }catch (SocketException e2){
                    //System.out.println("Server socket closed");
                    setRunning(false);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while accepting connection");
        }

    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

