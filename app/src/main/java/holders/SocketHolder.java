package holders;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class SocketHolder {
    private static Socket mSocket;
    private SocketHolder() {}

    public static Socket getInstance() {
        if (mSocket == null) {
            try {
                IO.Options options = new IO.Options();
                options.timeout = 700;
                options.reconnectionAttempts = 3;
                mSocket = IO.socket("https://place-your-guess.herokuapp.com/", options);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        if (!mSocket.connected()) mSocket.connect();

        return mSocket;
    }
}

//LBN: http://192.168.4.1:8080