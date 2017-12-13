package com.commen.utils;

import org.apache.poi.ss.formula.functions.T;

import java.io.*;

public class FileHelper {

    private String fileName;

    public FileHelper(){

    }

    public FileHelper(String fileName){
        this.fileName=fileName;
    }

    /*
     * 将对象保存到文件中
     */
    public void saveObjToFile(Object object){
        try {
            //写对象流的对象
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(object.getClass());                 //将Person对象p写入到oos中
            oos.close();                        //关闭文件流
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
     * 从文件中读取对象
     */
    public Object readFileToObj() throws IOException, ClassNotFoundException {
        Object object = null;
        //反序列化
        System.out.println(fileName);
            ObjectInput is =  new ObjectInputStream(new FileInputStream(fileName));
            object = is.readObject();

            System.out.println(object);
            is.close();
        return  object;
    }
}
