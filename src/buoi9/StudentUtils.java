package buoi9;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentUtils implements ToStringUtils<Student>{

    //    public static List<Student> filter(List<Student> students, Filterable filterable){
//        List<Student> result = new LinkedList<>();
//        for (Student student: students){
//            if(filterable.filter(student)){
//                result.add(student);
//            }
//        }
//        return result;
//    }
    public static List<Student> filter(List<Student> students, Predicate<Student> studentPredicate) {
        List<Student> result = new LinkedList<>();
        for (Student student : students) {
            if (studentPredicate.test(student)) {
                result.add(student);
            }
        }
        return result;
    }

    public static List<Student> filterUseStream(List<Student> students, Predicate<Student> studentPredicate) {
        return students.stream().filter(studentPredicate).collect(Collectors.toList());
    }
// orelse throww
    public static Student getBadStudent(List<Student> students) {
        return students.stream().filter(student -> student.getArgv() < 5).findFirst()
                .orElseThrow(() -> new RuntimeException("We do not have bad student"));
    }

    public static Student getStudentExllent(List<Student> students){
//        return students.stream().filter(student -> student.getArgv()==10).findFirst()
//                .orElseGet(() -> students.stream().max((s1,s2)->{
//                    float result = s1.getArgv() - s2.getArgv();
//                    return Float.floatToIntBits(result);
//                }).get());
        return  students.stream().max((s1,s2)->{
                                float result = s1.getArgv() - s2.getArgv();
                    return Float.floatToIntBits(result);
        }).get();
    }
}
