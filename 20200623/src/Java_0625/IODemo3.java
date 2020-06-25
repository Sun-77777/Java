package Java_0625;

import java.io.*;

class Student implements Serializable {
    public String name;
    public int age;
}
public class IODemo3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Student s = new Student();
        s.name = "张三";
        s.age = 2;
        serializeStudent(s);*/
        Student s = deserializeStudent();
        System.out.println(s.name);
        //System.getProperties().list(System.out);
    }

    private static Student deserializeStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/A/aaa.txt"));
        Student s = (Student) objectInputStream.readObject();
        objectInputStream.close();
        return s;
    }

    private static void serializeStudent(Student s) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/A/aaa.txt"));
        objectOutputStream.writeObject(s);
        objectOutputStream.close();
    }


}
