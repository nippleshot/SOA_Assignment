import error.LoginFailedFault;
import service.LoginInterface;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class TestClient {

    public static void main(String[] args) throws LoginFailedFault {
        URL url = null;
        try {
            url = new URL("http://localhost:8088/loginServer/service/LoginInterface?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        QName qname = new QName("http://service/", "LoginImplService");
        Service service = Service.create(url, qname);
        LoginInterface li = service.getPort(LoginInterface.class);


        System.out.println("=========< Login Success Test >=========");
        try{
            boolean test1 = li.checkLogin("175250001@smail.nju.edu.cn", "111111");
            System.out.println(test1);
        }catch (LoginFailedFault err){
            System.out.println(err.getFaultInfo());
        }

        try{
            boolean test2 = li.checkLogin("MG1934092@smail.nju.edu.cn", "12121");
            System.out.println(test2);
        }catch (LoginFailedFault err2){
            System.out.println(err2.getFaultInfo());
        }

        System.out.println("=========< Login Fail Test >=========");
        try{
            boolean test3 = li.checkLogin("rtw@nju.edu.cn", "000000");
            System.out.println(test3);
        }catch (LoginFailedFault err3){
            System.out.println(err3.getFaultInfo());
        }

        try{
            boolean test4 = li.checkLogin("rt123@bju.edu.cn", "111111");
            System.out.println(test4);
        }catch (LoginFailedFault err4){
            System.out.println(err4.getFaultInfo());
        }

    }
}