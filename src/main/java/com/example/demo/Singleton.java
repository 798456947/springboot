package com.example.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/** 
* Singleton 
* 
* @author crystalChen 
* @date 16/6/4 11:38 
*/  
public class Singleton {  

  private static int cntInstance = 0;  //防止第二次new对象  
  private static volatile Singleton instance = null;  

//  private Singleton() throws Exception{  
//      if (++cntInstance > 1)  
//          throw new Exception("try to new more than one singleton.");  
//      System.out.println("new a singleton.");  
//
//  }  
  private Singleton() throws Exception{  
	  cntInstance++;
      System.out.println("new a singleton.  "+"============================"+cntInstance);  

  }  
  public static Singleton getInstance() throws Exception{  
      if (null == instance) { //为了简洁度，不考虑线程安全  
          instance = new Singleton();  
      }  
      return instance;  
  }  

  public static void main(String[] args) {  
      try {  
          Singleton.getInstance();  

          Class singletonClass = Class.forName("com.example.demo.Singleton");  
//        Constructor[] cts = singletonClass.getConstructors(); 这种方式找不到私有构造器  
          Constructor[] cts = singletonClass.getDeclaredConstructors();  
          System.out.println("size: " + cts.length);  
          cts[0].setAccessible(true);  //访问权限打开setAccessible(true)，就可以访问私有构造函数  
          Singleton singleton = (Singleton)cts[0].newInstance();  

      } catch(ClassNotFoundException e) {  
          e.printStackTrace();  
      } catch (InvocationTargetException e) {  
          e.printStackTrace();  
      } catch (InstantiationException e) {  
          e.printStackTrace();  
      } catch (IllegalAccessException e) {  
          e.printStackTrace();  
      } catch (Exception e) {  
          e.printStackTrace();  
      }  

  }  
}  