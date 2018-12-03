package com.xzx.test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class GET_Test  {


public static void main(String[]args)throws IOException,URISyntaxException {
        //请求的地址

        String path = "http://localhost:8080/Login/patint";

        HttpURLConnection httpConn=null;
        BufferedReader in=null;
        try {
                URL url=new URL(path);
                httpConn=(HttpURLConnection)url.openConnection();

                //读取响应
                if(httpConn.getResponseCode()==HttpURLConnection.HTTP_OK){
                        StringBuffer content=new StringBuffer();
                        String tempStr="";
                        in=new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                        while((tempStr=in.readLine())!=null){
                                content.append(tempStr);
                        }
                        System.out.println(content.toString());
                }else{
                        System.out.println("2222");
                }
        } catch (IOException e) {
                e.printStackTrace();
        }finally{
                in.close();
                httpConn.disconnect();
        }

}


}
