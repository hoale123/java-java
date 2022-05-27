import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigDecimal;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<Integer, Boolean> weirdMap = new HashMap<>();
        weirdMap.put(4,false);
        weirdMap.put(9,true);
        weirdMap.put(10,false);
        weirdMap.put(4,true);
        weirdMap.put(4,true);
        /*
        weirdMap
        ================================
        keys                    values
        Integer(4) ------------- Boolean(true)
        Integer(9)-------------- Boolean(true)
        Integer(10) ------------ Boolean(false)
        =================================

         */


//        System.out.println("Harry was born in " + HarryStylesCDs.HARRYS_BIRTH_COUNTRY);
//        HarryStylesCDs cd1 = new HarryStylesCDs("Watermelon Sugar", new BigDecimal("15.99"),"pop");
//        HarryStylesCDs cd2 = new HarryStylesCDs("Girl Girl", new BigDecimal("15.99"),"acid pop");
//        HarryStylesCDs cd3 = cd1;
//
//        LinkedList<HarryStylesCDs> myLinkedList = new LinkedList<>();
//        myLinkedList.add(cd1);
//        myLinkedList.add(cd2);
//        myLinkedList.add(cd3);
//
////        System.out.println(myLinkedList.peekFirst());
////        System.out.println(myLinkedList.peekLast());
//
//        for (HarryStylesCDs disc : myLinkedList){
//            System.out.println(disc);
//        }
//        System.out.println("=======================");
//        myLinkedList.get(2).setGenre("country");
//        myLinkedList.get(1).setGenre("Wooo girl");

//        int i = 0;
//        while (i < 136){
//            System.out.println(i + ". Ryan is cultured");
//            i++;
//    }
            // a do/while loop
//        int j = 0;
//        do {
//            System.out.println(j + ". Michael is Right!!!");
//            j++;
//        }while (j < -50);

//        List<String> students = new ArrayList<>();
//        students.add("Rachel");
//
//        List<String> betterStudents = Arrays.asList("Joel", "Honorine", "Lloyd", "Joe", "Nelson", "Ryan");

//        for (int i = 0; i< students.size(); i++){
//             String outputString = generateGreeting(students.get(i));
//            System.out.println(outputString);
//        }
//
//        for (String student : betterStudents){
//            System.out.println(generateGreeting(student));
//        }
//        public static String generateGreeting(String name){
//            String returnVal = "Hello, ";
//            returnVal += " my name is " + name;
//        }
    }
    }
