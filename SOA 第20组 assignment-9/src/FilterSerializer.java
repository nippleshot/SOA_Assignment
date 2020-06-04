import com.nju.StudentList;
import com.nju.StudentScores;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class FilterSerializer {
    public static void main(String[] args) {

        try {
            File file = new File("xml文档3.xml");
            JAXBContext context1 = JAXBContext.newInstance(StudentScores.class);
            // 创建 UnMarshaller 实例
            Unmarshaller unmarshaller = context1.createUnmarshaller();
            // 加载需要转换的XML数据 -> 这里使用InputStream，还可以使用File，Reader等

            // 将XML数据序列化 -> 该方法的返回值为Object基类，需要强转类型
            StudentScores stuScoreList = (StudentScores) unmarshaller.unmarshal(file);



            JAXBContext jaxbContext2 = JAXBContext.newInstance(StudentScores.class);
            Marshaller jaxbMarshaller = jaxbContext2.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);

            ByteArrayOutputStream ba = new ByteArrayOutputStream();


            //调用StudentScores stuScoreList的findFail()返回筛选的不及格记录
            jaxbMarshaller.marshal(stuScoreList.findFail(), ba);


            //打印控制台
            System.out.println(ba);


            //生成文档4
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            StreamResult result = new StreamResult(new FileOutputStream(new File("./xml文档4.xml")));

            transformer.transform(
                    new StreamSource(new StringReader(ba.toString())),
                    result);

        } catch (JAXBException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }


}
