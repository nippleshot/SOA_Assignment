package com.studentservice;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.DateFormat;
import com.exception.RemoteServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentProcess {
    public Document document;
    private String srcPath;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    RemoteServerException rse = new RemoteServerException();
    public DocumentProcess(String srcPath){
        this.srcPath = srcPath;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            File file = new File(srcPath);
            db =  dbf.newDocumentBuilder();
            this.document = db.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student identifyByStudentId(String studentId, String password) throws RemoteServerException{
        if(!password.equals("12345")){
            rse.setMessage("authenticationFailedFault");
            throw rse;
        }

        boolean find = false;
        Student resStudent = new Student();
        NodeList students = document.getElementsByTagName("Student_Information");
        for(int i =0;i<students.getLength();i++){
            Element studentElement = (Element)students.item(i);
            if(studentElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)){
                find = true;
                resStudent.setName(studentElement.getElementsByTagName("Name").item(0).getTextContent());
                resStudent.setGender(studentElement.getElementsByTagName("Gender").item(0).getTextContent());
                resStudent.setBirthday(studentElement.getElementsByTagName("Birthday").item(0).getTextContent());
                resStudent.setPersonId(studentElement.getElementsByTagName("Person_Id").item(0).getTextContent());
                resStudent.setDepartment(studentElement.getElementsByTagName("Department").item(0).getTextContent());
                resStudent.setDormitory(studentElement.getElementsByTagName("Dormitory").item(0).getTextContent());
                resStudent.setStudentId(studentElement.getElementsByTagName("Student_Id").item(0).getTextContent());
                resStudent.setSchoolYear(studentElement.getElementsByTagName("School_Year").item(0).getTextContent());
                resStudent.setSchoolStatus(studentElement.getElementsByTagName("School_Status").item(0).getTextContent());
            }
        }
        if(!find){
            rse.setMessage("studentNotExistFault");
            throw rse;
        }
        if(!dataVaild(resStudent)){
            rse.setMessage("invalidDataFault");
            throw rse;
        }
        return  resStudent;
    }

    public Student identifyByIdCard(String personId, String password) throws RemoteServerException{
        if(!password.equals("12345")){
            rse.setMessage("authenticationFailedFault");
            throw rse;
        }
        boolean find = false;
        Student resStudent = new Student();
        NodeList students = document.getElementsByTagName("Student_Information");
        for(int i =0;i<students.getLength();i++){
            Element studentElement = (Element)students.item(i);
            if(studentElement.getElementsByTagName("Person_Id").item(0).getTextContent().equals(personId)){
                find = true;
                resStudent.setName(studentElement.getElementsByTagName("Name").item(0).getTextContent());
                resStudent.setGender(studentElement.getElementsByTagName("Gender").item(0).getTextContent());
                resStudent.setBirthday(studentElement.getElementsByTagName("Birthday").item(0).getTextContent());
                resStudent.setPersonId(studentElement.getElementsByTagName("Person_Id").item(0).getTextContent());
                resStudent.setDepartment(studentElement.getElementsByTagName("Department").item(0).getTextContent());
                resStudent.setDormitory(studentElement.getElementsByTagName("Dormitory").item(0).getTextContent());
                resStudent.setStudentId(studentElement.getElementsByTagName("Student_Id").item(0).getTextContent());
                resStudent.setSchoolYear(studentElement.getElementsByTagName("School_Year").item(0).getTextContent());
                resStudent.setSchoolStatus(studentElement.getElementsByTagName("School_Status").item(0).getTextContent());
            }
        }
        if(!find){
            rse.setMessage("studentNotExistFault");
            throw rse;
        }
        if(!dataVaild(resStudent)){
            rse.setMessage("invalidDataFault");
            throw rse;
        }

        return  resStudent;
    }

    public String identifyStudentStatus(String studentId) throws RemoteServerException {
        boolean find = false;
        String res = "";
        NodeList students = document.getElementsByTagName("Student_Information");
        for(int i =0;i<students.getLength();i++){
            Element studentElement = (Element)students.item(i);
            if(studentElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)){
                find = true;
                res = studentElement.getElementsByTagName("School_Status").item(0).getTextContent();
            }
        }
        if(!find){
            rse.setMessage("studentNotExistFault");
            throw rse;
        }
        if(!res.equals("true")&&!res.equals("false")){
            rse.setMessage("invalidDataFault");
            throw rse;
        }
        return res;
    }

    public String identifyDepartment(String studentId) throws RemoteServerException {
        boolean find = false;
        String res = "";
        NodeList students = document.getElementsByTagName("Student_Information");
        for(int i =0;i<students.getLength();i++){
            Element studentElement = (Element)students.item(i);
            if(studentElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)){
                find = true;
                res = studentElement.getElementsByTagName("Department").item(0).getTextContent();
            }
        }
        if(!find){
            rse.setMessage("studentNotExistFault");
            throw rse;
        }

        return res;
    }

    public String identifyDormitory(String studentId) throws RemoteServerException {
        boolean find = false;
        String res = "";
        NodeList students = document.getElementsByTagName("Student_Information");
        for(int i =0;i<students.getLength();i++){
            Element studentElement = (Element)students.item(i);
            if(studentElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)){
                find = true;
                res = studentElement.getElementsByTagName("Dormitory").item(0).getTextContent();
            }
        }
        if(!find){
            rse.setMessage("studentNotExistFault");
            throw rse;
        }
        return res;
    }

    public Student getStudentInfo(String studentId) throws RemoteServerException {
        boolean find = false;
        Student resStudent = new Student();
        NodeList students = document.getElementsByTagName("Student_Information");
        for(int i =0;i<students.getLength();i++){
            Element studentElement = (Element)students.item(i);
            if(studentElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)){
                find = true;
                resStudent.setName(studentElement.getElementsByTagName("Name").item(0).getTextContent());
                resStudent.setGender(studentElement.getElementsByTagName("Gender").item(0).getTextContent());
                resStudent.setBirthday(studentElement.getElementsByTagName("Birthday").item(0).getTextContent());
                resStudent.setPersonId(studentElement.getElementsByTagName("Person_Id").item(0).getTextContent());
                resStudent.setDepartment(studentElement.getElementsByTagName("Department").item(0).getTextContent());
                resStudent.setDormitory(studentElement.getElementsByTagName("Dormitory").item(0).getTextContent());
                resStudent.setStudentId(studentElement.getElementsByTagName("Student_Id").item(0).getTextContent());
                resStudent.setSchoolYear(studentElement.getElementsByTagName("School_Year").item(0).getTextContent());
                resStudent.setSchoolStatus(studentElement.getElementsByTagName("School_Status").item(0).getTextContent());
            }
        }
        if(!find){
            rse.setMessage("studentNotExistFault");
            throw rse;
        }
        if(!dataVaild(resStudent)){
            rse.setMessage("invalidDataFault");
            throw rse;
        }
        return  resStudent;
    }

    public ArrayList<Student> addStudentInfo(Student addStudent) throws RemoteServerException {
        NodeList students = document.getElementsByTagName("Student");
        boolean find = false;
        for (int i = 0; i < students.getLength(); i++) {
            Element studentElement = (Element) students.item(i);
            if (studentElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(addStudent.getStudentId())) {
                find = true;
                break;
            }
        }
        if(find){
            rse.setMessage("studentHasExistedFault");
            throw rse;
        }


        Element newName = document.createElement("Name");
        Text textName = document.createTextNode(addStudent.getName());
        newName.appendChild(textName);

        Element newGender = document.createElement("Gender");
        Text textGender = document.createTextNode(addStudent.getGender());
        newGender.appendChild(textGender);

        Element newBirthday = document.createElement("Birthday");
        Text textBirthday = document.createTextNode(addStudent.getBirthday());
        newBirthday.appendChild(textBirthday);

        Element newPersonId = document.createElement("Person_Id");
        Text textPersonId = document.createTextNode(addStudent.getPersonId());
        newPersonId.appendChild(textPersonId);

        Element newDepartment = document.createElement("Department");
        Text textDepartment = document.createTextNode(addStudent.getDepartment());
        newDepartment.appendChild(textDepartment);

        Element newDormitory = document.createElement("Dormitory");
        Text textDormitory = document.createTextNode(addStudent.getDormitory());
        newDormitory.appendChild(textDormitory);

        Element newStudentId = document.createElement("Student_Id");
        Text textStudentId = document.createTextNode(addStudent.getStudentId());
        newStudentId.appendChild(textStudentId);

        Element newSchoolYear = document.createElement("School_Year");
        Text textSchoolYear = document.createTextNode(addStudent.getSchoolYear());
        newSchoolYear.appendChild(textSchoolYear);

        Element newSchoolStatus = document.createElement("School_Status");
        Text textSchoolStatus = document.createTextNode(addStudent.getSchoolStatus());
        newSchoolStatus.appendChild(textSchoolStatus);

        Element newPersonInformation = document.createElement("Person_Information");
        newPersonInformation.appendChild(newName);
        newPersonInformation.appendChild(newGender);
        newPersonInformation.appendChild(newBirthday);
        newPersonInformation.appendChild(newPersonId);
        newPersonInformation.appendChild(newDepartment);
        newPersonInformation.appendChild(newDormitory);

        Element newStudentInformation = document.createElement("Student_Information");
        newStudentInformation.appendChild(newPersonInformation);
        newStudentInformation.appendChild(newStudentId);
        newStudentInformation.appendChild(newSchoolYear);
        newStudentInformation.appendChild(newSchoolStatus);

        Element newStudent = document.createElement("Student");
        newStudent.appendChild(newStudentInformation);

        Element root = (Element) document.getElementsByTagName("Student_List").item(0);
        root.appendChild(newStudent);

        saveChangeToFile();
        return getAllStudent();
    }

    public ArrayList<Student> deleteStudentInfo(String studentId) throws RemoteServerException {
        NodeList students = document.getElementsByTagName("Student");
        boolean find = false;
        for (int i = 0; i < students.getLength(); i++) {
            Element studentElement = (Element) students.item(i);
            if (studentElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)) {
                find = true;
                Node nodeToDel = students.item(i);
                nodeToDel.getParentNode().removeChild(nodeToDel);
                saveChangeToFile();
                break;
            }
        }
        if(!find){
            rse.setMessage("studentNotExistFault");
            throw rse;
        }
        return getAllStudent();
    }

    public ArrayList<Student> changeStudentInfo(Student student) throws RemoteServerException {
        if(!dataVaild(student)){
            rse.setMessage("invalidDataFault");
            throw rse;
        }
        NodeList students = document.getElementsByTagName("Student");
        boolean find = false;
        for (int i = 0; i < students.getLength(); i++) {
            Element studentElement = (Element) students.item(i);
            if (studentElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(student.getStudentId())) {
                find = true;
                studentElement.getElementsByTagName("Name").item(0).setTextContent(student.getName());
                studentElement.getElementsByTagName("Gender").item(0).setTextContent(student.getGender());
                studentElement.getElementsByTagName("Birthday").item(0).setTextContent(student.getBirthday());
                studentElement.getElementsByTagName("Person_Id").item(0).setTextContent(student.getPersonId());
                studentElement.getElementsByTagName("Department").item(0).setTextContent(student.getDepartment());
                studentElement.getElementsByTagName("Dormitory").item(0).setTextContent(student.getDormitory());
                studentElement.getElementsByTagName("School_Year").item(0).setTextContent(student.getSchoolYear());
                studentElement.getElementsByTagName("School_Status").item(0).setTextContent(student.getSchoolStatus());

                saveChangeToFile();
                break;
            }
        }
        if(!find){
            rse.setMessage("studentNotExistFault");
            throw rse;
        }

        return getAllStudent();
    }

    private void saveChangeToFile(){
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        Source source = new DOMSource(document);
        File file = new File(srcPath);
        Result result =new StreamResult(file);
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> studentsList = new ArrayList<>();
        NodeList students = document.getElementsByTagName("Student_Information");
        for(int i = 0;i<students.getLength();i++){
            Element student = (Element)students.item(i);
            Student newStudent = new Student();
            newStudent.setName(student.getElementsByTagName("Name").item(0).getTextContent());
            newStudent.setGender(student.getElementsByTagName("Gender").item(0).getTextContent());
            newStudent.setBirthday(student.getElementsByTagName("Birthday").item(0).getTextContent());
            newStudent.setPersonId(student.getElementsByTagName("Person_Id").item(0).getTextContent());
            newStudent.setDepartment(student.getElementsByTagName("Department").item(0).getTextContent());
            newStudent.setDormitory(student.getElementsByTagName("Dormitory").item(0).getTextContent());
            newStudent.setStudentId(student.getElementsByTagName("Student_Id").item(0).getTextContent());
            newStudent.setSchoolYear(student.getElementsByTagName("School_Year").item(0).getTextContent());
            newStudent.setSchoolStatus(student.getElementsByTagName("School_Status").item(0).getTextContent());
            studentsList.add(newStudent);
        }
        return studentsList;
    }

    private boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    private boolean dataVaild(Student student){

        if(student.getName().length()<2||student.getName().length()>15){
            return false;
        }

        if(!student.getGender().equals("Male")&&!student.getGender().equals("Female")){
            return false;
        }

        try {
            dateFormat.parse(student.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
            return  false;
        }

        if(!isNumeric(student.getPersonId())||student.getPersonId().length()!=18){
            return false;
        }

        if(!isNumeric(student.getStudentId())||student.getStudentId().length()!=9){
            return false;
        }

        if(!student.getSchoolStatus().equals("true")&&!student.getSchoolStatus().equals("false")){
            return  false;
        }

        if(!isNumeric(student.getSchoolYear())||student.getSchoolYear().length()!=4){
            return false;
        }

        return true;
    }
}
