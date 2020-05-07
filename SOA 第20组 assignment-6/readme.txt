基于httpServlet实现的遵循SOAP Response message exchange pattern的soap消息封装样例
通过HelloServlet类扩展httpServlet接收浏览器的post请求，
经由业务逻辑修改学生成绩
若出现错误则抛出异常返回fault信息。


运行说明：
运行前将PostServlet下的静态变量src改为src文件夹的绝对路径，之后点击运行
访问http://localhost:8008/soap/postMessage.html
输入修改信息后点击提交，成功将会跳转显示修改后的xml文件，本地xml内容也会被修改，网页内容格式不正确时请查看网页源代码
失败将会显示错误信息


