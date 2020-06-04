package model;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(
        name = "userType"
)
@XmlEnum
public enum LoginUserType {

    TEACHER("老师"),
    UNDER_GRADUATE("本科生"),
    POST_GRADUATE("研究生"),
    WRONG_EMAIL("未知类型");

    final private String user;

    LoginUserType(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }


}
