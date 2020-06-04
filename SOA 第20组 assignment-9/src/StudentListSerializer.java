import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.nju.*;
import com.nju.*;
import org.xml.sax.SAXException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentListSerializer {

    public static void main(String args[]) {

        String[][] info4Personal = {
                {"曹阳", "男", "1998-05-22", "123456781111112311", "软件学院"},
                {"赖童鑫", "男", "1998-02-20", "123456781111180111", "软件学院"},
                {"宋吉载", "男", "1996-03-22", "123456789118911111", "软件学院"},
                {"孙逸伦", "男", "1998-03-12", "123452781113511111", "软件学院"},
                {"张睿", "男", "1998-01-26", "123426781111681111", "软件学院"},
                {"王禹杰", "男", "1998-12-14", "123456781111111111", "软件学院"},
                {"詹志", "男", "1998-11-19", "123454781111991111", "软件学院"},
                {"顾韬", "男", "1998-11-12", "113452781111111111", "软件学院"},
                {"朱晓杰", "男", "1998-09-12", "413456781188111111", "软件学院"},
                {"王阳", "男", "1998-08-22", "623456781111111111", "软件学院"},
                {"陈煜遥", "男", "1998-01-22", "923456781166111111", "软件学院"},
                {"陈留圣", "男", "1998-06-12", "223456781111111111", "软件学院"},
                {"农增昀", "男", "1998-03-12", "423456781112211111", "软件学院"},
                {"胡丹丹", "女", "1998-01-15", "023456781133111111", "软件学院"},
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

        StudentListSerializer serializer = new StudentListSerializer();

        List<Student> testGroup = serializer.StudentListConstruct(info4Personal, info4StdPersonal);


        File CourseFile = new File("src/assignment2-schema/Course.xsd");
        File DepartmentFile = new File("src/assignment2-schema/Department.xsd");
        File PersonInfoFile = new File("src/assignment2-schema/PersonInfo.xsd");
        File ScoreListFile = new File("src/assignment2-schema/ScoreList.xsd");
        File StudentFile = new File("src/assignment2-schema/Student.xsd");
        File StudentListFile = new File("src/assignment2-schema/StudentList.xsd");

        Source[] source = {
                new StreamSource(CourseFile),
                new StreamSource(DepartmentFile),
                new StreamSource(PersonInfoFile),
                new StreamSource(ScoreListFile),
                new StreamSource(StudentFile),
                new StreamSource(StudentListFile)
        };
//        Score s=new Score("23",23);
//        List<Score> sl=new ArrayList<Score>();
//        sl.add(s);
//        sl.add(s);
//test tt=new test("1","2","3",sl);

        try {
            File file = new File("xml文档1.xml");
            JAXBContext context = JAXBContext.newInstance(Student.class);
            // 创建 UnMarshaller 实例
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // 加载需要转换的XML数据 -> 这里使用InputStream，还可以使用File，Reader等

            // 将XML数据序列化 -> 该方法的返回值为Object基类，需要强转类型
            Student stu = (Student) unmarshaller.unmarshal(file);
            // 将结果打印到控制台
            System.out.println(stu);



            testGroup.add(4, stu);

            StudentList test = new StudentList(testGroup);

            JAXBContext jaxbContext = JAXBContext.newInstance(StudentList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
//            SchemaFactory sf =
//                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema schema = sf.newSchema(
//                    StudentListFile);
//            jaxbMarshaller.setSchema(schema);
            ByteArrayOutputStream ba = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(test, ba);
            System.out.println(ba);


            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            StreamResult result = new StreamResult(new FileOutputStream(new File("./xml文档2.xml")));

            transformer.transform(
                    new StreamSource(new StringReader(ba.toString())),
                    result);


        } catch (JAXBException | TransformerException | FileNotFoundException e) {
            e.printStackTrace();
        }
//        catch (SAXException e) {
//            e.printStackTrace();
//        }

    }


    private List<Student> StudentListConstruct(String[][] info4Personal, String[][] info4StdPersonal) {
        List<Student> newSL = new ArrayList<Student>();

        for (int i = 0; i < info4Personal.length; i++) {
            newSL.add(studentConstruct(info4Personal[i], info4StdPersonal[i]));
        }

        return newSL;
    }

    private Student studentConstruct(String[] infoPer, String[] infoStPer) {
        PersonInfo newP = new PersonInfo(infoPer[0], infoPer[1], infoPer[2], infoPer[3], infoPer[4]);
        StudentPersonInfo newSP = new StudentPersonInfo(newP, infoStPer[0], infoStPer[1], infoStPer[2]);

        Student newS = new Student(newSP, ScoreGenerate(infoStPer[0]));

        return newS;
    }

    private StudentScores ScoreGenerate(String sid) {
        Random random = new Random();




        List<CourseScore> courseScoreList = new ArrayList<CourseScore>();
        for (int i = 1; i <= 5; i++) {

            Score s1 = new Score(sid, random.nextInt((100 - 60) + 1) + 50);
            Score s2 = new Score(sid, random.nextInt((100 - 60) + 1) + 50);
            Score s3 = new Score(sid, random.nextInt((100 - 60) + 1) + 50);

            CourseScore newCs1 = new CourseScore(s1, "平时成绩", "0000000" + i);
            CourseScore newCs2 = new CourseScore(s2, "期末成绩", "0000000" + i);
            CourseScore newCs3 = new CourseScore(s3, "总评成绩", "0000000" + i);

            courseScoreList.add(newCs1);
            courseScoreList.add(newCs2);
            courseScoreList.add(newCs3);
        }

        StudentScores newSS = new StudentScores(courseScoreList);


        return newSS;
    }


}
