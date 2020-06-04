-StudentSerializer.java
通过jaxb将com.nju下的根据schema规范编写的java类实例化，导入xml文档1.xml转化为Student对象，
并添加到硬编码的StudentList中，随机生成成绩。最终输出为xml文档2.xml


-TransformSerializer
读入xml文档2.xml，通过jaxb实例化为StudentList对象，调用StudentList内部的SelectAll()函数合并所有的Student的StudentScores并返回合并后的StudentScores，
StudentScores对象调用Sort对类内部的List<CourseScores> courseScores排序，排序原则为（学号/课程编码/成绩）依次比较从小到大
最后把结果输出到xml文档3

-FilterSerializer
读入xml文档3，通过jaxb实例化为StudentScores并调用内部的findFail（）函数返回所有包含不及格成绩的课程成绩
将结果输出到xml文档4