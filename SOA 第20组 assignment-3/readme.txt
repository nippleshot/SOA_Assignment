- fixXML1():
    把从XML1（171250024.xml）读取的 '<学生>'元素做修改。
    添加了课程编号 '00000001'，'00000002'，'00000003'的平时成绩和期末成绩。
    添加了课程编号 '00000004'，'00000005'的平时成绩，期末成绩，总评成绩。

- makeXMLFile():
    生成XML2叫 'StudentList.xml'

- makeStudentList():
    生产 '<学生列表>'元素
    生成14个 '<学生>'元素。

- makeStudent():
    生成 '<学生>'元素

- makeStdPersonalInfo():
    生成 '<学生个人信息>'元素
    为了生成子元素 '<个人信息>'，调用了makePersonalInfo()。

- makePersonalInfo():
    生成 '<个人信息>'元素

- makeStdScore():
    生成 '<学生分数>'元素

- makeClassScoreList():
    生成 '<课程成绩列表>'元素
    生成每个课程编号（从'00000001'到'00000005'）的平时成绩,期末成绩,总评成绩。

- makeTotalScoreElement():
    生成 '<课程成绩 课程编号="xxxxx" 成绩性质="总评成绩">'元素
    为了生成子元素 '<成绩>'，调用了makeScoreElement()。

- makeFinalScoreElement():
    生成 '<课程成绩 课程编号="xxxxx" 成绩性质="期末成绩">'元素
    为了生成子元素 '<成绩>'，调用了makeScoreElement()。

- makeDailyScoreElement():
    生成 '<课程成绩 课程编号="xxxxx" 成绩性质="平时成绩">'元素
    为了生成子元素 '<成绩>'，调用了makeScoreElement()。

- makeScoreElement():
    生成 '<成绩>'元素
    得分的话，使用了60~100之间的Random.nextInt()

- fixStudentList():
    在生成好的'<学生列表>'元素里修改5个学生的课程编号'00000001'的平时成绩低于60

- main():
    首先，通过调用fixXML1()，修改XML1的'<学生>'元素
    生成一个包括14个'<学生>'元素的'<学生列表>'元素
    使用importNode()之后,添加之前修改XML1的'<学生>'元素到'<学生列表>'元素里
    通过fixStudentList()，修改了'<学生列表>'元素里的<得分>内容。
    最后通过调用makeXMLFile()，生成'StudentList.xml'文件