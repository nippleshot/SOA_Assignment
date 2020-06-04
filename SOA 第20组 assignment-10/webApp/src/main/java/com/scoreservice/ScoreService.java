package com.scoreservice;

import com.exception.RemoteServerException;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;


@WebService
public class ScoreService {
    private static String srcPath = "F:\\study\\webApp\\src\\scoreList.xml";
    DocumentProcess dp = new DocumentProcess(srcPath);

    public String getScore(String studentId) throws RemoteServerException {
        return dp.getScore(studentId);
    }

    public String getClassAverage(String courseId) throws RemoteServerException {
        return dp.getClassAverage(courseId);
    }

    public String addScore(String courseId, String studentId, String scoreType, String score) throws RemoteServerException {
        return dp.addScore(courseId, studentId,scoreType,score);
    }

    public String  fixScore(String courseId, String studentId, String scoreType, String score) throws RemoteServerException {
        return dp.fixScore(courseId, studentId,scoreType,score);
    }

    public String  deleteScore(String courseId, String studentId, String scoreType) throws RemoteServerException {
        return dp.deleteScore(courseId, studentId,scoreType);
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/ScoreService/",new ScoreService());
        System.out.println("Score Service Server Start......");
    }
}