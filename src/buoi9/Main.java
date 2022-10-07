package buoi9;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        tu java 8 la interface co the viet dc ten ham
//        default KieuDuLieu tenham(){
//
//          }
//        default no khong nhan
//        đọc sách java modern Java in action, java 17

//        linkedlist nó có thêm vô tận còn array list bạn phải thêm cho nó cái size
//        cái hạn chế của cái linklist này là nếu mình thêm ở index 101 đi. thì nó sẽ dò từ 0 đến 101 để tìm đến cái phần tử
//        trong đó. phải tốn thời gian. cho dù các index đều bỏ trống. còn arraylist nó có giới hạn phần size nên bạn khó
//        mà bỏ trống nó đc
//        linkedlist này dùng cho việc xóa sửa dữ liệu. còn array list dùng cho show dữ liệu

//    list.of mình không thể thay đổi vị trí trong cái list.of này
//        Unmodifiable Lists
        List<String> list = List.of("23","asdas","sadzx");

        //        mutableList :  đụng chạm dc
        List<String> listMutable = new ArrayList<>();
        listMutable.add("asdas");
        listMutable.add("as123");
        listMutable.add("Vzxc");
//        list.sort((o1, o2) -> {
//            return o1.compareTo(o2);
//        });

//        cach 1 de sort
//        listMutable.sort((o1, o2) -> {
//            return o1.compareTo(o2);
//        });
//        cach 2 de sort
//        listMutable.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
////                sort chieu thuan
////                return o1.compareTo(o2);
////                sort chieu nguoc
//                return o1.compareTo(o2)*(-1);
//            }
//        });
//        System.out.println(listMutable.toString());


        List<Student> listStudent = new LinkedList<>();
        listStudent.add(new Student("nam",6));
        listStudent.add(new Student("v2",1));
        listStudent.add(new Student("thanh",10));
        listStudent.add(new Student("tu",6));


//        - có thể tạo một đối tượng bằng interface
//        - để sài được lamda (arrowFunction) thì interface phải bắt buộc chỉ có 1 funcition duy nhất 1 interface
//        mà chỉ có duy một fucntion thì đó đc gọi là @FunctionalInterface ngoài trừ có defatult ra
//        - Thực ra bạn không cần phải dùng hàm filter đâu. vì đã có 1 hàm trong java.utils.function là hàm
//        predicate nó nhận trả về boolean. tham số nhận vào là bất kỳ kiểu dữ liệu nào.
//        nhưng phải khai báo cho tạm cho nó để nó biết là cái nào nhé
//        thực ra còn nhiều nữa vào java.utils.function để mà đọc thêm get, accept,
//        List<Student> studentsNormal = StudentUtils.filter(listStudent, new Filterable() {
//            @Override
//            public boolean filter(Student student) {
//                if(student.getArgv() > 5 && student.getArgv() <7){
//                    return true;
//                }
//                return false;
//            }
//        });


        List<Student> studentsNormal = StudentUtils.filter(listStudent, student -> {
            return student.getArgv() > 5 && student.getArgv() < 7;
        });

        //        Có cái mới là Stream .filter(predicate).tolist() nó giống với filter.
//        cái này là chỉ cần đọc hàm là hiểu nó làm gì. không phải coi từng dòng code nó nói gì
        List<Student> studentsNormaluseStream = StudentUtils.filterUseStream(listStudent, student -> {
            return student.getArgv() > 5 && student.getArgv() < 7;
        });

//        lọc => đổi kiểu dữ liệu lọc => cho ra cái mình muốn
        Predicate<Student> isGoodStudent = student -> student.getArgv() >6;
//        Function
//        Function<Student,String> getName = student -> student.getName();
//        hoặc như này đều đc
          Function<Student,String> getName = Student::getName;

        List<String> goodStudentNames = listStudent.stream().filter(isGoodStudent)
                .map(getName).collect(Collectors.toList());

//        anymatch, allmatch, nonematch check kiem tra truong hop
        Predicate<Student> isBadStudent = student -> student.getArgv() <6;
        boolean hasStudentAvg9 = listStudent.stream().anyMatch(student -> student.getArgv() > 9);
        boolean hasBadStudent = listStudent.stream().anyMatch(isBadStudent);
        boolean allPass = listStudent.stream().allMatch(student -> student.getArgv() > 5);
        System.out.println(allPass);
//        System.out.println("co phan tu nao lon hon 9 khong " + hasStudentAvg9);
        System.out.println(goodStudentNames.toString());


//        Optional - cai nay dung de lam việc liên quan đến null. nếu giá trị là null nó sẽ in ra thứ khác trong
//        trường hợp này. khắc phục lỗi nullpointerexpection


//        vao cac ham khac de coi nhe
        String name = null;
        System.out.println(Optional.ofNullable(name).orElse("Can not find name"));


        int badScore = listStudent.stream().filter(isBadStudent)
                .map(Student::getArgv)
                .findFirst().orElse(4);

        Student badStudent = StudentUtils.getBadStudent(listStudent);
        System.out.println(badStudent);

        Student goodStudent = StudentUtils.getStudentExllent(listStudent);
        System.out.println(goodStudent);

        System.out.println(badScore);

//        học anation
//        hoc Generic


        StudentUtils uiUtils = new StudentUtils();
        uiUtils.print(new Student(),Student.class);
    }


}

