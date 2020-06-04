package com.scoreservice;

import com.exception.RemoteServerException;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentProcess {
    public  Document document;
    private String srcPath;
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

    public String getScore(String studentId) throws RemoteServerException {
        if (!isNumeric(studentId) || studentId.length() != 9){
            rse.setMessage("invalidStudentId");
            throw rse;
        }
        boolean find = false;
        String outMessage = "Student ID: "+studentId+"\n";
        NodeList scores = document.getElementsByTagName("Course_Score");
        for(int i = 0;i<scores.getLength();i++){
            Element scoreElement = (Element)scores.item(i);
            if(scoreElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)){
                find = true;
                outMessage += "Course ID: " +  scoreElement.getAttribute("Course_Id")+"\n";
                outMessage += "Score Type: " +  scoreElement.getAttribute("Score_Type")+"\n";
                if(!isNumeric(scoreElement.getElementsByTagName("Credit").item(0).getTextContent())){
                    rse.setMessage("dataError");
                    throw rse;
                }
                outMessage += "Score: "+  scoreElement.getElementsByTagName("Credit").item(0).getTextContent()+"\n\n";
            }
        }
        if(!find){
            rse.setMessage("noExistStudentId");
            throw rse;
        }
        return  outMessage;
    }

    public String getClassAverage(String courseId) throws RemoteServerException {
        if (!isNumeric(courseId) || courseId.length() != 8){
            rse.setMessage("invalidCourseId");
            throw rse;
        }
        int cnt = 0;
        double res = 0.0;
        boolean findScore = false;
        NodeList scores = document.getElementsByTagName("Course_Score");
        for(int i = 0;i<scores.getLength();i++){
            Element scoreElement = (Element)scores.item(i);
            if(scoreElement.getAttribute("Course_Id").equals(courseId)&&scoreElement.getAttribute("Score_Type").equals("Final_Score")){
                findScore = true;
                cnt++;
                if(!isNumeric(scoreElement.getElementsByTagName("Credit").item(0).getTextContent())){
                    rse.setMessage("dataError");
                    throw rse;
                }
                res+=Double.parseDouble(scoreElement.getElementsByTagName("Credit").item(0).getTextContent()) ;
            }
        }

        if(findScore){
            return String.valueOf(res/cnt);
        }else {
            rse.setMessage("notExistCourseId");
            throw rse;
        }
    }

    public String addScore(String courseId, String studentId, String scoreType, String score) throws RemoteServerException {
        if (!isNumeric(courseId) || courseId.length() != 8){
            rse.setMessage("invalidCourseId");
            throw rse;
        }
        if (!isNumeric(studentId) || studentId.length() != 9){
            rse.setMessage("invalidStudentId");
            throw rse;
        }
        if (!isNumeric(score) || Integer.parseInt(score)>100){
            rse.setMessage("invalidScore");
            throw rse;
        }
        if (!scoreType.equals("Daily_Score")&&!scoreType.equals("Final_Score")&&!scoreType.equals("End_Exam_Score")){
            rse.setMessage("invalidScoreType");
            throw rse;
        }

        NodeList scores = document.getElementsByTagName("Course_Score");
        for(int i = 0;i<scores.getLength();i++){
            Element scoreElement = (Element)scores.item(i);
            if(scoreElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)){
                rse.setMessage("dataAlreadyExist");
                throw rse;
            }
        }

        Element courseScore = document.createElement("Course_Score");
        Element newScore = document.createElement("Score");
        Element newStudentId = document.createElement("Student_Id");
        Element newCredit = document.createElement("Credit");

        Attr attr1 = document.createAttribute("Score_Type");
        attr1.setValue(scoreType);
        Attr attr2 = document.createAttribute("Course_Id");
        attr2.setValue(courseId);

        Text txtStudentId = document.createTextNode(studentId);
        Text txtCredit = document.createTextNode(score);

        newStudentId.appendChild(txtStudentId);
        newCredit.appendChild(txtCredit);

        newScore.appendChild(newStudentId);
        newScore.appendChild(newCredit);
        courseScore.appendChild(newScore);

        courseScore.setAttributeNode(attr1);
        courseScore.setAttributeNode(attr2);

        Element courseList = (Element) document.getElementsByTagName("Course_Score_List").item(0);

        courseList.appendChild(courseScore);



        newStudentId.setNodeValue(studentId);

        newCredit.setNodeValue(score);
        newScore.appendChild(newStudentId);
        newScore.appendChild(newCredit);
        courseScore.appendChild(newScore);

        courseList.appendChild(courseScore);
        saveChangeToFile();

        return "Success";
    }

    public String fixScore(String courseId, String studentId, String scoreType, String score) throws RemoteServerException {
        if (!isNumeric(courseId) || courseId.length() != 8){
            rse.setMessage("invalidCourseId");
            throw rse;
        }
        if (!isNumeric(studentId) || studentId.length() != 9){
            rse.setMessage("invalidStudentId");
            throw rse;
        }
        if (!isNumeric(score) || Integer.parseInt(score)>100){
            rse.setMessage("invalidScore");
            throw rse;
        }
        if (!scoreType.equals("Daily_Score")&&!scoreType.equals("Final_Score")&&!scoreType.equals("End_Exam_Score")){
            rse.setMessage("invalidScoreType");
            throw rse;
        }

        NodeList scores = document.getElementsByTagName("Course_Score");
        boolean findScore = false;
        for (int i = 0; i < scores.getLength(); i++) {
            Element scoreElement = (Element) scores.item(i);
            if (scoreElement.getAttribute("Course_Id").equals(courseId) && scoreElement.getAttribute("Score_Type").equals(scoreType) && scoreElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)) {
                findScore = true;
                scoreElement.getElementsByTagName("Credit").item(0).setTextContent(score);
                saveChangeToFile();
                break;
            }
        }
        if(!findScore){
            rse.setMessage("notExistStudentIdScoreMatch");
            throw rse;
        }
        return "Success";
    }

    public String deleteScore(String courseId, String studentId, String scoreType) throws RemoteServerException {
        if (!isNumeric(courseId) || courseId.length() != 8){
            rse.setMessage("invalidCourseId");
            throw rse;
        }
        if (!isNumeric(studentId) || studentId.length() != 9){
            rse.setMessage("invalidStudentId");
            throw rse;
        }
        if (!scoreType.equals("Daily_Score")&&!scoreType.equals("Final_Score")&&!scoreType.equals("End_Exam_Score")){
            rse.setMessage("invalidScoreType");
            throw rse;
        }

        NodeList scores = document.getElementsByTagName("Course_Score");
        boolean findScore = false;
        for (int i = 0; i < scores.getLength(); i++) {
            Element scoreElement = (Element) scores.item(i);
            if (scoreElement.getAttribute("Course_Id").equals(courseId) && scoreElement.getAttribute("Score_Type").equals(scoreType) && scoreElement.getElementsByTagName("Student_Id").item(0).getTextContent().equals(studentId)) {
                findScore = true;
                Node nodeToDel = scores.item(i);
                nodeToDel.getParentNode().removeChild(nodeToDel);
                saveChangeToFile();
                break;
            }
        }

        if(!findScore){
            rse.setMessage("notExistStudentIdScoreMatch");
            throw rse;
        }
        return "Success";
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

    private boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }
}
