package service;

import error.LoginFailedFault;
import model.LoginUserType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebService(endpointInterface = "service.LoginInterface")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class LoginImpl implements LoginInterface{

    private static Map<String, String> under_GraduateAccount = new HashMap<>();
    private static Map<String, String> post_GraduateAccount = new HashMap<>();
    private static Map<String, String> teacherAccount = new HashMap<>();
    static {
        under_GraduateAccount.put("175250001@smail.nju.edu.cn", "111111");
        post_GraduateAccount.put("MG1934092@smail.nju.edu.cn", "12121");
        teacherAccount.put("rtw@nju.edu.cn", "12345");
    }
    @Override
    public boolean checkLogin(String email, String pwd) throws LoginFailedFault {
        LoginUserType[] types = {LoginUserType.TEACHER, LoginUserType.POST_GRADUATE, LoginUserType.UNDER_GRADUATE, LoginUserType.WRONG_EMAIL};
        Map[] accounts = {teacherAccount, post_GraduateAccount, under_GraduateAccount};

        LoginUserType checked = verifyEmail(email);
        for(int i=0; i<types.length; i++){
            if(i==3){
                throw new LoginFailedFault("This is not NJU Email", "Email Invalid");
            }
            if(checked.equals(types[i])){
                if(accounts[i].get(email).equals(pwd)){
                    System.out.println("Login Success : identity = " + types[i].getUser());
                    return true;
                }else{
                    throw new LoginFailedFault("Incorrect Email or Password", "Password Incorrect");
                }
            }
        }
        return false;
    }

    @WebMethod(
            exclude = true
    )
    private LoginUserType verifyEmail(String email){
        String beforeAt = email.split("@")[0];
        String afterAt = email.split("@")[1];

        String underGraduateRegex = "^(\\d{9})$";
        String postGraduateRegex = "^([A-Z]{2})(\\d){7}$";

        Pattern underGraduatePattern = Pattern.compile(underGraduateRegex);
        Matcher underGraduateMatcher = underGraduatePattern.matcher(beforeAt);
        Pattern postGraduatePattern = Pattern.compile(postGraduateRegex);
        Matcher postGraduateMatcher = postGraduatePattern.matcher(beforeAt);

        if(afterAt.equals("smail.nju.edu.cn")) {
            if(underGraduateMatcher.matches()){
                return LoginUserType.UNDER_GRADUATE;
            }
            if(postGraduateMatcher.matches()){
                return LoginUserType.POST_GRADUATE;
            }
        }else if(afterAt.equals("nju.edu.cn")){
            return LoginUserType.TEACHER;
        }else{
            return LoginUserType.WRONG_EMAIL;
        }
        return null;
    }
}
