public class Recap {
    public static String main(String person) {
//        String person = "Joel";
        String quote = "";

        switch (person){
            case "Joel":
                return "Should i sign a new lease?";
            case "Alonzo":
                return " There are 60 seconds in a minute.";
            case "Ryan":
                quote = " There are 60 seconds in a minute.";
            default:
                quote += " There are 60 seconds in a minute.";
        }
        System.out.println(person + " says" + quote);
        return quote;
    }
}
