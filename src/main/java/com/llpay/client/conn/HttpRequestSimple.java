package com.llpay.client.conn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

public class HttpRequestSimple{

    private static HttpRequestSimple instance;

    public static HttpRequestSimple getInstance()
    {
        if (instance == null)
        {
            instance = new HttpRequestSimple();
        }
        return instance;
    }

    private HttpRequestSimple()
    {

    }

    /**
     * 
     * 功能描述：发送序列化对象
     * @param url
     * @param inputObj
     * @return
     */
    public Object postSendHttp(String url, Object inputObj)
    {
        long start = System.currentTimeMillis();
        if (url == null || "".equals(url))
        {
            System.out.println("request url is empty.");
            return null;
        }
        HttpClient httpClient = CustomHttpClient.GetHttpClient();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/octet-stream");
        java.io.ByteArrayOutputStream bOut = new java.io.ByteArrayOutputStream(
                1024);
        java.io.InputStream bInput = null;
        java.io.ObjectOutputStream out = null;
        Serializable returnObj = null;
        try
        {
            out = new java.io.ObjectOutputStream(bOut);
            out.writeObject(inputObj);
            out.flush();
            out.close();
            out = null;
            bInput = new java.io.ByteArrayInputStream(bOut.toByteArray());
            InputStreamEntity inputStreamEntity = new InputStreamEntity(bInput,
                    bOut.size(), null);
            inputStreamEntity.setContentEncoding(new BasicHeader(
                    HTTP.CONTENT_ENCODING, "UTF-8"));
            // 设置请求主体
            post.setEntity(inputStreamEntity);
            // 发起交易
            HttpResponse resp = httpClient.execute(post);
            System.out.println("请求[" + url + "] " + resp.getStatusLine());
            int ret = resp.getStatusLine().getStatusCode();
            if (ret == HttpStatus.SC_OK)
            {
                // // // 响应分析
                // HttpEntity entity = resp.getEntity();
                // returnObj = (Serializable) SerializationUtils.deserialize(entity.getContent());
                // return returnObj;

                // 响应分析
                HttpEntity entity = resp.getEntity();

                java.io.InputStream in = entity.getContent();
                java.io.ObjectInputStream oInput = new java.io.ObjectInputStream(
                        in);
                returnObj = (Serializable) oInput.readObject();
                oInput.close();
                oInput = null;
                long end = System.currentTimeMillis();
                System.out.println("请求[" + url + "]消耗时间 " + (end - start)
                        + "毫秒");
                return returnObj;
            }
            return null;
        } catch (ConnectTimeoutException cte)
        {
            System.out.println(cte.getMessage());
            return null;
        } catch (SocketTimeoutException cte)
        {
            System.out.println(cte.getMessage());
            return null;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String postSendHttp(String url, String body)
    {
        long start = System.currentTimeMillis();
        if (url == null || "".equals(url))
        {
            System.out.println("request url is empty.");
            return null;
        }
        HttpClient httpClient = CustomHttpClient.GetHttpClient();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json;charset=UTF-8");
        try
        {
            StringEntity stringEntity = new StringEntity(body, "UTF-8");
            stringEntity.setContentEncoding(new BasicHeader(
                    HTTP.CONTENT_ENCODING, "UTF-8"));
            // 设置请求主体
            post.setEntity(stringEntity);
            // 发起交易
            HttpResponse resp = httpClient.execute(post);
            int ret = resp.getStatusLine().getStatusCode();
            if (ret == HttpStatus.SC_OK)
            {
                // 响应分析
                HttpEntity entity = resp.getEntity();

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        entity.getContent(), "UTF-8"));
                StringBuffer responseString = new StringBuffer();
                String result = br.readLine();
                while (result != null)
                {
                    responseString.append(result);
                    result = br.readLine();
                }
                long end = System.currentTimeMillis();
                System.out.println("请求[" + url + "]消耗时间 " + (end - start)
                        + "毫秒");
                return responseString.toString();
            }
            return null;
        } catch (ConnectTimeoutException cte)
        {
            System.out.println(cte.getMessage());
            return null;
        } catch (SocketTimeoutException cte)
        {
            System.out.println(cte.getMessage());
            return null;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getSendHttp(String url)
    {
        if (url == null || "".equals(url))
        {
            System.out.println("request url is empty.");
            return null;
        }
        HttpClient httpClient = CustomHttpClient.GetHttpClient();
        HttpGet get = new HttpGet(url);
        get.setHeader("Content-Type", "text/html;charset=UTF-8");
        try
        {
            // 发起交易
            HttpResponse resp = httpClient.execute(get);
            System.out.println("请求[" + url + "] " + resp.getStatusLine());
            int ret = resp.getStatusLine().getStatusCode();
            if (ret == HttpStatus.SC_OK)
            {
                // 响应分析
                HttpEntity entity = resp.getEntity();

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        entity.getContent()));
                StringBuffer responseString = new StringBuffer();
                String result = br.readLine();
                while (result != null)
                {
                    responseString.append(result);
                    result = br.readLine();
                }

                return responseString.toString();
            }
            return null;
        } catch (ConnectTimeoutException cte)
        {
            System.out.println(cte.getMessage());
            return null;
        } catch (SocketTimeoutException cte)
        {
            System.out.println(cte.getMessage());
            return null;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String postPramaList(String url, NameValuePair[] list)
    {
        List<NameValuePair> nvList = new ArrayList<NameValuePair>();
        for (NameValuePair nameValue : list)
        {
            nvList.add(nameValue);
        }
        return postPramaList(nvList, url);
    }

    public String postPramaList(List<NameValuePair> list, String url)
    {
        HttpClient httpClient = CustomHttpClient.GetHttpClient();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=utf-8");
        BufferedReader br = null;
        try
        {
            UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(list,
                    HTTP.UTF_8);
            // 设置请求参数
            post.setEntity(formEntiry);
            // 发起交易
            HttpResponse resp = httpClient.execute(post);
            System.out.println("请求[" + url + "] " + resp.getStatusLine());
            int ret = resp.getStatusLine().getStatusCode();
            if (ret == HttpStatus.SC_OK)
            {
                // 响应分析
                HttpEntity entity = resp.getEntity();
                br = new BufferedReader(new InputStreamReader(entity
                        .getContent(), "UTF-8"));
                StringBuffer responseString = new StringBuffer();
                String result = br.readLine();
                while (result != null)
                {
                    responseString.append(result);
                    result = br.readLine();
                }
                return responseString.toString();
            } else
            {
                System.out.println("retcode:" + ret);
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        } finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                } catch (IOException e)
                {
                    // do nothing
                }
            }
        }
    }

}
