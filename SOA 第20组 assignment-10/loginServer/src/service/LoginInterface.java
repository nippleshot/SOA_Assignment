package service;

import error.LoginFailedFault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LoginInterface {

    @WebMethod
    boolean checkLogin(@WebParam(name = "email") String email, @WebParam(name = "password") String password) throws LoginFailedFault;

}
