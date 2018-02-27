package com.oneUtil.classLoader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by houyunjuan on 2018/2/27.
 */
public class NetworkClassLoader extends ClassLoader {

    String host;
    int port;

    @Override
    protected Class<?> findClass(String name) {
        byte[] b = new byte[0];
        try {
            b = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,b,0,b.length);
    }
    private byte[] loadClassData(String name) throws IOException {
        URL url = new URL("http://localhost:8081/qimen/orders");
        URLConnection connection = url.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        byte[] b = new byte[1024];
        int len = 0;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            while((len = inputStream.read(b)) != -1){
                baos.write(b,0,len);
            }
        }finally {
           if (null != inputStream){
               inputStream.close();
           }
        }
        System.out.println(baos.size());
        return baos.toByteArray();
    }


    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
