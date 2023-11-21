package com.classLoading;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class DIClassLoader {

    public static Class loadClass(String className){
        Class loadedClass;
        try{
            URL classUrl;
//            D:\intellij19Projects\DoshmanInvaderVII\additional contents\CircularDoshmanSet.class
            classUrl = new URL("file:///D:\\intellij19Projects\\DoshmanInvaderVII\\additional contents\\"+className);
            URL[] urls = {classUrl};
            URLClassLoader classLoader = new URLClassLoader(urls);
            loadedClass = classLoader.loadClass(className);
            return loadedClass;

        }catch (MalformedURLException e){
            e.printStackTrace();
            return null;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
