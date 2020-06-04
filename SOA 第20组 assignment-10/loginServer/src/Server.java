import service.LoginImpl;

import javax.xml.ws.Endpoint;

public class Server {

    public Server() {

    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8088/loginServer/service/LoginInterface", new LoginImpl());
    }
}