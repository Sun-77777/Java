package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TsetJson {
    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        //1.实例化 (工厂模式)
        Gson gson = new GsonBuilder().create();
        //2.把一个对象转成json字符串。
        Student student = new Student("qq",20);
        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
        //3.把json字符串变成对象
        String json = "\"name\":\"qq\",\"age\":20";
        gson.fromJson(json,Student.class);
    }
}
