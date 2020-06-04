
package com.studentservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentService", targetNamespace = "http://studentservice.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentService {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.studentservice.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "identifyByStudentId", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyByStudentId")
    @ResponseWrapper(localName = "identifyByStudentIdResponse", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyByStudentIdResponse")
    @Action(input = "http://studentservice.com/StudentService/identifyByStudentIdRequest", output = "http://studentservice.com/StudentService/identifyByStudentIdResponse")
    public Student identifyByStudentId(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "identifyStudentStatus", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyStudentStatus")
    @ResponseWrapper(localName = "identifyStudentStatusResponse", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyStudentStatusResponse")
    @Action(input = "http://studentservice.com/StudentService/identifyStudentStatusRequest", output = "http://studentservice.com/StudentService/identifyStudentStatusResponse")
    public String identifyStudentStatus(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.studentservice.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getStudentInfo", targetNamespace = "http://studentservice.com/", className = "com.studentservice.GetStudentInfo")
    @ResponseWrapper(localName = "getStudentInfoResponse", targetNamespace = "http://studentservice.com/", className = "com.studentservice.GetStudentInfoResponse")
    @Action(input = "http://studentservice.com/StudentService/getStudentInfoRequest", output = "http://studentservice.com/StudentService/getStudentInfoResponse")
    public Student getStudentInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "identifyDepartment", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyDepartment")
    @ResponseWrapper(localName = "identifyDepartmentResponse", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyDepartmentResponse")
    @Action(input = "http://studentservice.com/StudentService/identifyDepartmentRequest", output = "http://studentservice.com/StudentService/identifyDepartmentResponse")
    public String identifyDepartment(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.studentservice.Student>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addStudentInfo", targetNamespace = "http://studentservice.com/", className = "com.studentservice.AddStudentInfo")
    @ResponseWrapper(localName = "addStudentInfoResponse", targetNamespace = "http://studentservice.com/", className = "com.studentservice.AddStudentInfoResponse")
    @Action(input = "http://studentservice.com/StudentService/addStudentInfoRequest", output = "http://studentservice.com/StudentService/addStudentInfoResponse")
    public List<Student> addStudentInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        Student arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.studentservice.Student>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "changeStudentInfo", targetNamespace = "http://studentservice.com/", className = "com.studentservice.ChangeStudentInfo")
    @ResponseWrapper(localName = "changeStudentInfoResponse", targetNamespace = "http://studentservice.com/", className = "com.studentservice.ChangeStudentInfoResponse")
    @Action(input = "http://studentservice.com/StudentService/changeStudentInfoRequest", output = "http://studentservice.com/StudentService/changeStudentInfoResponse")
    public List<Student> changeStudentInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        Student arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.studentservice.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "identifyByIdCard", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyByIdCard")
    @ResponseWrapper(localName = "identifyByIdCardResponse", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyByIdCardResponse")
    @Action(input = "http://studentservice.com/StudentService/identifyByIdCardRequest", output = "http://studentservice.com/StudentService/identifyByIdCardResponse")
    public Student identifyByIdCard(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.studentservice.Student>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteStudentInfo", targetNamespace = "http://studentservice.com/", className = "com.studentservice.DeleteStudentInfo")
    @ResponseWrapper(localName = "deleteStudentInfoResponse", targetNamespace = "http://studentservice.com/", className = "com.studentservice.DeleteStudentInfoResponse")
    @Action(input = "http://studentservice.com/StudentService/deleteStudentInfoRequest", output = "http://studentservice.com/StudentService/deleteStudentInfoResponse")
    public List<Student> deleteStudentInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "identifyDormitory", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyDormitory")
    @ResponseWrapper(localName = "identifyDormitoryResponse", targetNamespace = "http://studentservice.com/", className = "com.studentservice.IdentifyDormitoryResponse")
    @Action(input = "http://studentservice.com/StudentService/identifyDormitoryRequest", output = "http://studentservice.com/StudentService/identifyDormitoryResponse")
    public String identifyDormitory(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
