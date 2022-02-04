package com.company;

// modificadores de accceso ----> encapsulamiento

class Student {
    private String name;
    private String lastname;
    private String code;

    //Constructores

    Student (String name, String lastname, String code){
        this.name = name;
        this.lastname = lastname;
        this.code = code;
    }
    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //getters

    public String getName(){
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCode() {
        return code;
    }
}

class Group{
    private String code;
    private Student[] students;
    private int enrolled;
    private int rejected;

    public Group(String code, int capacity) {
        this.code = code;
        students = new Student[capacity];
    }

    public String getCode() {
        return code;
    }

    public boolean addStudents(Student student){
        if(enrolled <students.length){
            students[enrolled++] = student;
            return true;
        }
        System.out.println("Estudiante no fue añadido " + student.getName() + " " + student.getLastname() + " " + student.getCode());//Imprime los que no fueron añadidos
        rejected ++;
        return false;
    }


    public void printGroup(){
        System.out.println("Grupo: " + code + ", inscritos: " + enrolled + ", rechazados: " + rejected); //Imprime los datos de los grupos
    }

    public void printStudent() {
        System.out.println();
        System.out.println("Alumnos del grupo: " + code);                                               //Imprime los datos de los alumnos
        for (int k = 0; k <enrolled; k++) {
            Student student = students[k];
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastname());
        }
    }

    public void removeStudent(String code) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getCode() == code) {
                for (int j=i;j<students.length-1;j++) {
                    students[j] = students[j + 1];
                }
                enrolled=enrolled-1;
                break;
            }
        }
    }

   /* public int getRejected() {
        return rejected;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public Student getStudent(int index){
        return students[index];
    }*/
}

public class Main {

    public static void main(String[] args) {
        Student student1;  //Referencia a un Student
        Student student2 = new Student("ivan","Uresti","2332");

        student1 = new Student("Jose","Gonzales","2323"); //creando un objeto alumno

        student1.setName("Ivan");
        student2.setName("pedro");

        Group group =new Group("230401", 8);
        Group group2 =new Group("230402", 6);

        group.addStudents(student1);
        group.addStudents(student2);
        group.addStudents(new Student("Jorge","Acosta","1"));
        group2.addStudents(new Student("Arturo","Aleman","2"));
        group2.addStudents(new Student("Antonio","Angel","3"));
        group.addStudents(new Student("Francisco","Arreguin","4"));
        group.addStudents(new Student("Misael","Cabrera","5"));
        group.addStudents(new Student("Roberto","Cisneros","6"));
        group.addStudents(new Student("Juan","Coronado","7"));
        group.addStudents(new Student("Jose","Gonzales","8"));
        group.addStudents(new Student("Jesus","Lara","9"));
        group.addStudents(new Student("Jose","Limon","10"));

        group.printGroup();
        group2.printGroup();

        group.removeStudent("1");
        group2.removeStudent("2");

        group.printGroup();
        group2.printGroup();


        group.printStudent();
        group2.printStudent();
    }
}
