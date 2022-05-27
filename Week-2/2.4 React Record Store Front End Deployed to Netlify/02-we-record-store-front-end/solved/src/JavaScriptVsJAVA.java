class Hotel {
      public int bookings;
      public void book() {
   bookings++; // increment bookings
       }
       }


       public class SuperHotel extends Hotel {
       public void book() {
       bookings--;// override booking to decrement
      }

      public void book(int size) {
  book();
      super.book();
      bookings += size;
      }
      public static void main(String args[]) {
  Hotel hotel = new Hotel();
  hotel.book(2);
      System.out.print(hotel.bookings);
      }
    }
