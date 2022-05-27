import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HarryStylesCDs {
    //state are the variable of Harry Styles
    //behavioral are the methods of Harry Style
    //Identity is the new HarryStylesCDs
    //Wrapper class,
//    Map<Integer, Boolean> weirdMap = new HashMap<>();
//    weirdMap.put(4,false)

    //composition - use dot notation.
    //HarryStylesCds has
    //delegation house.kitchen

    //Inheritance ;use extends
        // has of
        //House has Kitchen has Appliances
        //StaffMember, TeamLead, Developer
            //Why is StaffMember Abstract
            // shouldn't be able to make a new staff member.
        //public abstract void

    //Abstract must have a 1.06
        //with an Abstract class you can't make another instant of that class
            //use abstract
        // must call the same method name to access the abstract method
    //
    private String name;//name is the state
    private BigDecimal price;//price is the state
    private String genre;// genre is the state
    //REVIEW
//    public static final String HARRYS_BIRTH_COUNTRY = "England";

    public HarryStylesCDs() {
    }

    public HarryStylesCDs(String name, BigDecimal price, String genre) {
        this.name = name;
        this.price = price;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HarryStylesCDs that = (HarryStylesCDs) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, genre);
    }

    @Override
    public String toString() {
        return "HarryStykesCDs{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }
}


