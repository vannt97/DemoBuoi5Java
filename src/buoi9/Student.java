package buoi9;

public class Student  {




    private String name;
    private int argv;

    public Student() {
    }
    @Override
    public String toString() {
        return String.format("Student[name: %s, arv: %d] %n", name,argv).toString();
    }

    public Student(String name, int argv) {
        this.name = name;
        this.argv = argv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArgv() {
        return argv;
    }

    public void setArgv(int argv) {
        this.argv = argv;
    }



}
