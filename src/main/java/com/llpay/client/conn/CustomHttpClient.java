package com.llpay.client.conn;

/**
 * 
 */

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

/**
 * 线程安全的HttpCLient,单例模式，支持http、https协议
 * 
 * @author linys
 */
public class CustomHttpClient{
    private static HttpClient customHttpClient          = httpClientInstance();
    private static final int  TIME_OUT                  = 1000 * 60;
    private static final int  MAX_CONNECTIONS_TOTAL     = 200;
    private static final int  MAX_CONNECTIONS_PER_ROUTE = 50;

    private CustomHttpClient()
    {
    }

    public static HttpClient GetHttpClient()
    {
        return customHttpClient;
    }

    private static HttpClient httpClientInstance()
    {

        KeyStore trustStore;
        SSLSocketFactory sf = null;
        try
        {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            sf = new MySSLSocketFactory(trustStore);
            sf
                    .setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (KeyManagementException e)
        {
            System.out.println(e.getMessage());
        } catch (NoSuchAlgorithmException e)
        {
            System.out.println(e.getMessage());
        } catch (UnrecoverableKeyException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        } catch (CertificateException e)
        {
            System.out.println(e.getMessage());
        } catch (KeyStoreException e)
        {
            System.out.println(e.getMessage());
        }

        SchemeRegistry schReg = new SchemeRegistry();
        schReg.register(new Scheme("http", PlainSocketFactory
                .getSocketFactory(), 80));
        schReg.register(new Scheme("https", sf, 443));

        PoolingClientConnectionManager conMgr = new PoolingClientConnectionManager(
                schReg);
        conMgr.setMaxTotal(MAX_CONNECTIONS_TOTAL);
        conMgr.setDefaultMaxPerRoute(MAX_CONNECTIONS_PER_ROUTE);

        customHttpClient = new DefaultHttpClient(conMgr);

        HttpParams params = customHttpClient.getParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
        HttpConnectionParams.setConnectionTimeout(params, TIME_OUT);
        HttpConnectionParams.setSoTimeout(params, TIME_OUT);
        return customHttpClient;
    }

    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

}
