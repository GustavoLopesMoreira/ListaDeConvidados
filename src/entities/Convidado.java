package entities;


public class Convidado {
    private String name;
    private Integer age;


    public Convidado(String name, Integer age) {
        this.name = name;
        this.age = age;

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return  name + " " + age + " anos";
    }
}