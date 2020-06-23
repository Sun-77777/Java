import java.io.*;

class Student implements Serializable {
    public String name;
    public int age;
    public int score;
}
public class IODemo5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Student s = new Student();
        s.name = "zhangsan";
        s.age = 20;
        s.score = 100;
        serializeStudent(s);*/
        Student s = deserializeStudent();
        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.score);
    }

    private static void serializeStudent(Student s) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/student.txt"));
        objectOutputStream.writeObject(s);
        //writeObject 集序列化 + 写文件 两者同时搞定
        objectOutputStream.close();
    }

    private static Student deserializeStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/student.txt"));
        Student s = (Student) objectInputStream.readObject();
        //readObject  一次读一个
        return s;
    }

}
