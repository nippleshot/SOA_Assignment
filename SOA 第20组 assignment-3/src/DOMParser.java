import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

    public Element fixXML1(Document document) throws XPathExpressionException{
        //root
        Element rootStudent = document.getDocumentElement();

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();

        //find node to insert
        String expression = "//课程成绩列表";
        NodeList nodes = (NodeList) xpath.compile(expression).evaluate(rootStudent, XPathConstants.NODESET);
        Element where2Insert = (Element)nodes.item(0);

        //add 平时成绩, 期末成绩 for each 00000001,00000002, 00000003 classes
        for(int i = 1; i<4; i++){
            String classNum = "0000000" + String.valueOf(i);
            String studentID = "171250024";

            Element elementDaily = makeDailyScoreElement(document, classNum, studentID);
            Element elementFinal = makeFinalScoreElement(document, classNum, studentID);

            where2Insert.appendChild(elementDaily);
            where2Insert.appendChild(elementFinal);
        }

        //add 00000004,00000005 classes
        for(int i = 4; i<6; i++){
            String classNum = "0000000" + String.valueOf(i);
            String studentID = "171250024";

            Element elementDaily = makeDailyScoreElement(document, classNum, studentID);
            Element elementFinal = makeFinalScoreElement(document, classNum, studentID);
            Element elementTotal = makeTotalScoreElement(document, classNum, studentID);

            where2Insert.appendChild(elementDaily);
            where2Insert.appendChild(elementFinal);
            where2Insert.appendChild(elementTotal);
        }
        return rootStudent;
    }

    public Element makeStudentList(Document document, String[][] Infos, String[][] Infos2){
        Element studentList = document.createElement("学生列表");

        // make 14 <学生> and put everything in <学生列表>
        for(int i=0; i<14; i++){
            Element student = makeStudent(document, Infos[i], Infos2[i][0], Infos2[i][1], Infos2[i][2]);
            studentList.appendChild(student);
        }

        return studentList;
    }

    public Element makeStudent(Document document, String[] Infos, String stdSchoolId, String stdYearOf, String stdStatus){
        Element student = document.createElement("学生");

        Element stdPersonalInfo = makeStdPersonalInfo(document, Infos, stdSchoolId, stdYearOf, stdStatus);
        Element stdScore = makeStdScore(document, stdSchoolId);

        student.appendChild(stdPersonalInfo);
        student.appendChild(stdScore);

        return student;
    }

    public Element makePersonalInfo(Document document, String[] Infos){
        //String[] Infos ==> String stdName, String stdSex, String stdBirth, String stdId, String stdDept
        Element personalInfo = document.createElement("个人信息");

        Element name = document.createElement("名字");
        name.setTextContent(Infos[0]);
        Element sex = document.createElement("性别");
        sex.setTextContent(Infos[1]);
        Element birth = document.createElement("出生日期");
        birth.setTextContent(Infos[2]);
        Element identityNum = document.createElement("身份证号");
        identityNum.setTextContent(Infos[3]);
        Element department = document.createElement("部门");
        department.setTextContent(Infos[4]);

        personalInfo.appendChild(name);
        personalInfo.appendChild(sex);
        personalInfo.appendChild(birth);
        personalInfo.appendChild(identityNum);
        personalInfo.appendChild(department);

        return personalInfo;
    }

    public Element makeStdPersonalInfo(Document document, String[] Infos, String stdSchoolId, String stdYearOf, String stdStatus){
        Element stdPersonalInfo = document.createElement("学生个人信息");

        Element personalInfo = makePersonalInfo(document, Infos);
        Element schoolID = document.createElement("学号");
        schoolID.setTextContent(stdSchoolId);
        Element yearOf = document.createElement("入学年级");
        yearOf.setTextContent(stdYearOf);
        Element status = document.createElement("学籍状态");
        status.setTextContent(stdStatus);

        stdPersonalInfo.appendChild(personalInfo);
        stdPersonalInfo.appendChild(schoolID);
        stdPersonalInfo.appendChild(yearOf);
        stdPersonalInfo.appendChild(status);

        return stdPersonalInfo;
    }

    public Element makeStdScore(Document document, String stdSchoolId){
        Element stdScore = document.createElement("学生分数");

        Element classScoreList = makeClassScoreList(document, stdSchoolId);
        stdScore.appendChild(classScoreList);

        return stdScore;
    }

    // making 平时成绩,期末成绩,总评成绩 for each class from 00000001 ~ 00000005
    public Element makeClassScoreList(Document document, String stdSchoolId){
        Element classScoreList = document.createElement("课程成绩列表");

        for(int i=1; i<6; i++){
            String classNum = "0000000" + String.valueOf(i);
            Element elementDaily = makeDailyScoreElement(document, classNum, stdSchoolId);
            Element elementFinal = makeFinalScoreElement(document, classNum, stdSchoolId);
            Element elementTotal = makeTotalScoreElement(document, classNum, stdSchoolId);

            classScoreList.appendChild(elementDaily);
            classScoreList.appendChild(elementFinal);
            classScoreList.appendChild(elementTotal);
        }

        return classScoreList;
    }

    public Element makeScoreElement(Document document, String id){
        Element score = document.createElement("成绩");

        Element scoreSchoolID = document.createElement("学号");
        scoreSchoolID.setTextContent(id);
        Element scoreGot = document.createElement("得分");

        Random random = new Random();
        int randomSixty2Hunnit = random.nextInt((100-60)+1) + 60;
        scoreGot.setTextContent(String.valueOf(randomSixty2Hunnit));
        score.appendChild(scoreSchoolID);
        score.appendChild(scoreGot);

        return score;
    }

    public Element makeTotalScoreElement(Document document, String classNum, String id){

        Element classScore = document.createElement("课程成绩");
        classScore.setAttribute("成绩性质","总评成绩");
        classScore.setAttribute("课程编号", classNum);
        Element score = makeScoreElement(document, id);

        classScore.appendChild(score);
        return classScore;
    }

    public Element makeFinalScoreElement(Document document, String classNum, String id){

        Element classScore = document.createElement("课程成绩");
        classScore.setAttribute("成绩性质","期末成绩");
        classScore.setAttribute("课程编号", classNum);
        Element score = makeScoreElement(document, id);

        classScore.appendChild(score);
        return classScore;
    }

    public Element makeDailyScoreElement(Document document, String classNum, String id){

        Element classScore = document.createElement("课程成绩");
        classScore.setAttribute("成绩性质","平时成绩");
        classScore.setAttribute("课程编号", classNum);
        Element score = makeScoreElement(document, id);

        classScore.appendChild(score);
        return classScore;
    }

    public void makeXMLFile(Document document, Element root) throws TransformerException, FileNotFoundException {
        document.appendChild(root);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileOutputStream(new File("./StudentList.xml")));

        transformer.transform(source, result);
    }

    public void printElement(Element element) throws TransformerException {
        // XML 문자열로 변환하기! //
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        DOMSource source = new DOMSource(element);
        StreamResult result = new StreamResult(out);

        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();

        // 출력 시 문자코드: UTF-8
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        // 들여 쓰기 있음
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml. customer .org/xslt}indent-amount", "4");
        transformer.transform(source, result);

        System.out.println(new String(out.toByteArray(), StandardCharsets.UTF_8));
    }

    public Element fixStudentList(Element element) throws XPathExpressionException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();

        //find node to fix
        String expression = "//得分";
        NodeList nodes = (NodeList) xpath.compile(expression).evaluate(element, XPathConstants.NODESET);


        //and just fix five student's '平时成绩' from 课程编号'00000001'
        for(int i=0; i<nodes.getLength(); i++){
            if(i%15==0){
                Element where2Fix = (Element)nodes.item(i);
                Random random = new Random();
                int randomTen2Sixty = random.nextInt((60-10)+1) + 10;
                where2Fix.setTextContent(String.valueOf(randomTen2Sixty));
            } else if (i==77) {
                break;
            }
        }

        return element;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException, TransformerException {
        //XML1 Parsing
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document2Read = documentBuilder.parse("171250024.xml");
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        DOMParser domParser = new DOMParser();
        Element studentFromXML1 = domParser.fixXML1(document2Read);
//        domParser.printElement(studentFromXML1);
        String[][] info4Personal = {
                {"曹阳","男","1998-05-22","123456781111112311","软件学院"},
                {"赖童鑫","男","1998-02-20","123456781111180111","软件学院"},
                {"宋吉载","男","1996-03-22","123456789118911111","软件学院"},
                {"孙逸伦","男","1998-03-12","123452781113511111","软件学院"},
                {"张睿","男","1998-01-26","123426781111681111","软件学院"},
                {"王禹杰","男","1998-12-14","123456781111111111","软件学院"},
                {"詹志","男","1998-11-19","123454781111991111","软件学院"},
                {"顾韬","男","1998-11-12","113452781111111111","软件学院"},
                {"朱晓杰","男","1998-09-12","413456781188111111","软件学院"},
                {"王阳","男","1998-08-22","623456781111111111","软件学院"},
                {"陈煜遥","男","1998-01-22","923456781166111111","软件学院"},
                {"陈留圣","男","1998-06-12","223456781111111111","软件学院"},
                {"农增昀","男","1998-03-12","423456781112211111","软件学院"},
                {"胡丹丹","女","1998-01-15","023456781133111111","软件学院"},
        };

        String[][] info4StdPersonal = {
                {"171250550", "2017", "有"},
                {"171250520", "2017", "有"},
                {"155250001", "2015", "有"},
                {"171250511", "2017", "有"},
                {"171250533", "2017", "有"},
                {"171250587", "2017", "有"},
                {"171250540", "2017", "有"},
                {"171250530", "2017", "有"},
                {"171250529", "2017", "有"},
                {"171250515", "2017", "有"},
                {"171250503", "2017", "有"},
                {"171250552", "2017", "有"},
                {"171250541", "2017", "有"},
                {"171250528", "2017", "有"}
        };

        Element studentList = domParser.makeStudentList(document, info4Personal, info4StdPersonal);
        Node XML1Student = document.importNode(studentFromXML1, true);
        studentList.appendChild(XML1Student);

//        domParser.printElement(studentList);

        studentList = domParser.fixStudentList(studentList);
//        domParser.printElement(studentList);

        domParser.makeXMLFile(document, studentList);
    }
}
