package error;


import javax.xml.ws.WebFault;

@WebFault(
        name = "InvalidDataFault"
)
public class LoginFailedFault extends Exception {
    private String faultInfo;

    public LoginFailedFault(String message, String faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }


    public String getFaultInfo() {
        return this.faultInfo;
    }
}