package com.Controllers;

import java.util.LinkedList;

public class LoadedClassesController {
    LinkedList<Class> classes = new LinkedList<>();

    public void addClass(Class aClass){
        classes.add(aClass);
        System.out.println("sdaas");
    }

    public LinkedList<Class> getClasses() {
        return classes;
    }
}
