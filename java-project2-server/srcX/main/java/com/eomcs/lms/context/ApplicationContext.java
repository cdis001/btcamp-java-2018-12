package com.eomcs.lms.context;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.ibatis.io.Resources;
import com.eomcs.lms.handler.Command;

public class ApplicationContext {

  ArrayList<Class<?>> classes = new ArrayList<>();
  
  HashMap<String, Object> beans = new HashMap<String, Object>();

  public ApplicationContext(String packageName, Map<String,Object> beans) throws Exception {

    if(beans != null && beans.size() > 0) {
      Set<String> names = beans.keySet();
      for(String name : names) {
        addBean(name, beans.get(name));
      }
    }
    
    File packageDir = Resources.getResourceAsFile(
        packageName.replace(".", "/"));
    System.out.println(packageDir.getCanonicalPath());

    findClasses(packageDir, packageName);
    prepareCommand();

  }
  
  private void addBean(String name, Object bean) {
    
    if (name == null || name.length() == 0 || bean == null) {
      return;
    }
    beans.put(name, bean);
  }

  private void findClasses(File dir, String packageName) throws Exception {
    File[] files = dir.listFiles((File pathname) -> {
        if (pathname.isDirectory())
          return true;
        if(pathname.getName().endsWith(".class") &&
            !pathname.getName().contains("$"))
          return true;

        return false;
    });

    for (File f : files) {

      if(f.isFile()) {
        String fileName = f.getName();
        String className = packageName + "." + 
            fileName.substring(0, fileName.indexOf('.'));
        Class<?> clazz = Class.forName(className);
        if(clazz.isLocalClass() || clazz.isInterface() || clazz.isEnum()) {
          continue;
        }
        if (Modifier.isAbstract(clazz.getModifiers()) || 
            !Modifier.isPublic(clazz.getModifiers())) {
          continue;
        }

        classes.add(clazz);
      } else {
        findClasses(f, packageName + "." + f.getName());
      }
    }
  }

  private void prepareCommand() throws Exception {
    
    for(Class<?> clazz : classes){
      List<Class<?>> interfaces = getAllInterfaces(clazz);
      for(Class<?> i : interfaces) {
        if (i == Command.class) {
          System.out.println(clazz.getName());
          break;
        }
      }
    }
  }
  
  private List<Class<?>> getAllInterfaces(Class<?> clazz) {
    ArrayList<Class<?>> list = new ArrayList<>();
    
    while(clazz != Object.class) {
      Class<?>[] interfaces = clazz.getInterfaces();
      for(Class<?> i : interfaces) {
        list.add(i);
      }
      clazz = clazz.getSuperclass();
    }
    return list;
  }
  
}
