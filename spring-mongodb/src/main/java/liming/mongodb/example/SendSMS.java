/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
package liming.mongodb.example;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendSMS {

    /**
     * @description: (这里用一句话描述这个方法的作用)
     * @author anzengli (anzengli@sohu-inc.com)
     * @date 2016-8-25 下午3:18:58
     * @version V1.0
     * @method: main
     * @param args void SendSMS
     * @throws IOException
     * @throws HttpException
     */
    public static void main(String[] args) throws HttpException, IOException {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn/");
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码

        NameValuePair[] data = {
                new NameValuePair("Uid", "menglongfeihu"), // 注册的用户名
                new NameValuePair("Key", "999d90c23b579165609d"), // 注册成功后,登录网站使用的密钥
                new NameValuePair("smsMob", "13212159327"), // 手机号码
                new NameValuePair("smsText", "富贵英")// 设置短信内容
        };
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        for (Header header : headers) {
            System.out.println(header.toString());
        }

        String result = new String(post.getResponseBodyAsString().getBytes(), "gbk");
        System.out.println(result);
        post.releaseConnection();

    }

}
