package com.oneUtil.classLoader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by houyunjuan on 2018/2/27.
 */
public class NetworkClassLoader extends ClassLoader {

    String name;

    //类存放的路径
    private String path = "D:\\installsofts\\git\\gitworkspace\\target\\classes\\com\\ehaoyao\\qimen\\models\\";
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
        try {
//            name = name.replace(".", "//");
            FileInputStream is = new FileInputStream(new File(path + name + ".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = is.read()) != -1) {
                baos.write(b);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public NetworkClassLoader(String name) {
        this.name = name;
    }
}
