package servlet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.*;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String src = "/Users/vincentmoriarty/Downloads/Assignment 6 SOAP Message/src/";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {

            File is = new File(xmlStr);
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(is);
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        String courseID = request.getParameter("courseID");
        String studentID = request.getParameter("studentID");
        String scoreType = request.getParameter("scoreType");
        String score = request.getParameter("score");
        try {
            SOAPMessage res = setStudentMessage(studentID, courseID, scoreType, score);
            Document doc = res.getSOAPPart().getEnvelope().getOwnerDocument();
            StringWriter output = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(output));
            out.write(output.toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private SOAPMessage setStudentMessage(String studentId, String courseID, String scoreType, String score) throws Exception {//构建soap消息
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage message = messageFactory.createMessage();
        Document document = convertStringToDocument(src + "scoreList.xml");//读取xml数据文件转化为document对像
        //检查id是否合法
        if (!isNumeric(studentId) || studentId.length() != 9) {
            message.getSOAPPart().getEnvelope().getBody().addFault().setFaultString("StudentIdError");
            message.saveChanges();
            return message;
        }
        //检查CourseId是否合法
        if (!isNumeric(courseID) || courseID.length() != 8) {
            message.getSOAPPart().getEnvelope().getBody().addFault().setFaultString("CourseIdError");
            message.saveChanges();
            return message;
        }
        //检查得分是否合法
        if (!isNumeric(score) || Integer.valueOf(score) > 100) {
            message.getSOAPPart().getEnvelope().getBody().addFault().setFaultString("ScoreError");
            message.saveChanges();
            return message;
        }
        //检查成绩性质是否合法
        if (!scoreType.equals("平时成绩") && !scoreType.equals("期末成绩") && !scoreType.equals("总评成绩")) {
            message.getSOAPPart().getEnvelope().getBody().addFault().setFaultString("ScoreTypeError");
            message.saveChanges();
            return message;
        }
        //检查studentId是否存在
        if (!FindStudentExist(studentId, document)) {
            SOAPFault fault = message.getSOAPPart().getEnvelope().getBody().addFault();
            fault.setFaultString("StudentIdNotFound");
            fault.setFaultCode("FindStudentExist");
            message.saveChanges();
            return message;
        }

        //检查是否存在符合要求课程编号和成绩性质
        NodeList scores = document.getElementsByTagName("课程成绩");
        boolean findScore = false;
        for (int i = 0; i < scores.getLength(); i++) {
            Element scoreElement = (Element) scores.item(i);
            if (scoreElement.getAttribute("课程编号").equals(courseID) && scoreElement.getAttribute("成绩性质").equals(scoreType) && scoreElement.getElementsByTagName("学号").item(0).getTextContent().equals(studentId)) {
                findScore = true;
                scoreElement.getElementsByTagName("得分").item(0).setTextContent(score);
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                Source source = new DOMSource(document);
                File file = new File(src + "scoreList.xml");
                Result result = new StreamResult(file);
                transformer.transform(source, result);
                break;
            }
        }
        if (findScore) {
            SOAPPart soapPart = message.getSOAPPart();// 创建soap部分
            SOAPEnvelope envelope = soapPart.getEnvelope();
            SOAPBody body = envelope.getBody();
            body.addDocument(document);//数据插入body
        } else {
            SOAPFault fault = message.getSOAPPart().getEnvelope().getBody().addFault();
            fault.setFaultString("SuchScoreNotFound");
            fault.setFaultCode("FindScoreExist");
        }


        message.saveChanges();
        return message;
    }

    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    private Boolean FindStudentExist(String id, Document document) {
        NodeList stuIdList = document.getElementsByTagName("学号");
        for(int i =0;i<stuIdList.getLength();i++){
            if(stuIdList.item(i).getTextContent().equals(id)){
                return true;
            }
        }
        return false;
    }
}