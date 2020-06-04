import com.nju.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.nju.*;
public class TransformSerializer {

    public static void main(String[] args) {
        try {
            //读入文档2
            File file = new File("xml文档2.xml");
            JAXBContext context1 = JAXBContext.newInstance(StudentList.class);
            // 创建 UnMarshaller 实例
            Unmarshaller unmarshaller = context1.createUnmarshaller();
            // 加载需要转换的XML数据 -> 这里使用InputStream，还可以使用File，Reader等

            // 将XML数据序列化 -> 该方法的返回值为Object基类，需要强转类型
            StudentList stuList = (StudentList) unmarshaller.unmarshal(file);


            JAXBContext jaxbContext2 = JAXBContext.newInstance(StudentScores.class);
            Marshaller jaxbMarshaller = jaxbContext2.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
//            SchemaFactory sf =
//                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema schema = sf.newSchema(
//                    StudentListFile);
//            jaxbMarshaller.setSchema(schema);

            //提取排序
            class ScoreComparetor implements Comparator<CourseScore> {
                private int toint(String s) {
                    return Integer.parseInt(s);
                }

                @Override

                public int compare(CourseScore h1, CourseScore h2) {

                    if (toint(h1.score.StudentId) > toint(h2.score.StudentId)) {
                        return 1;
                    } else if (toint(h1.score.StudentId) == toint(h2.score.StudentId)) {
                        if (toint(h1.courseId) > toint(h2.courseId)) {
                            return 1;
                        } else if (toint(h1.courseId) == toint(h2.courseId)) {
                            if (h1.score.score > h2.score.score) {
                                return 1;
                            }
                            else if(h1.score.score == h2.score.score){
                                return 0;
                            }
                            else{
                                return -1;
                            }

                        } else {
                            return -1;
                        }

                    } else {
                        return -1;
                    }
                }

            }
            List<CourseScore> clist=stuList.selectAll().findL();
            Collections.sort(clist, new ScoreComparetor());
            StudentScores outcome=new StudentScores(clist);
            ByteArrayOutputStream ba = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(outcome, ba);
            //打印控制台
            System.out.println(ba);


            //生成文档3
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            StreamResult result = new StreamResult(new FileOutputStream(new File("./xml文档3.xml")));

            transformer.transform(
                    new StreamSource(new StringReader(ba.toString())),
                    result);

        } catch (JAXBException | FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }

    }



}
