import java.time.LocalDate;

public class Blud {
  public static void main(String[] args) throws Exception {

  Library library = new Library();
  StudentMember member1 = new StudentMember("meow", 123456);
  RegularMember member2 = new RegularMember("hey", 134);

  library.addMember(member1);
  library.addMember(member2);


  LibraryItem hah = new Book("hello", 123);
  LibraryItem gah = new Magazine("meow", 122);
  LibraryItem mag = new Magazine("Hey", 976);
  LibraryItem lah = new Book("blah", 876);
  LibraryItem rec = new RefrenceBook("blud", 854);

  library.addItem(lah);
  library.addItem(gah);
  library.addItem(hah);
  library.addItem(mag);
  library.addItem(rec);

  java.time.LocalDate localDate1 = LocalDate.of(2026, 1, 12);
  java.time.LocalDate localDateForReturn = LocalDate.of(2026, 1, 21);
  java.time.LocalDate localDate2 = LocalDate.of(2026, 1, 11);


  library.borrowItem(member2.getId(), lah.getId(), localDate1);
  library.borrowItem(member2.getId(), mag.getId(), localDate2);
  library.borrowItem(member2.getId(), gah.getId(), localDate1);
  library.borrowItem(member2.getId(), hah.getId(), localDate2);
  

  System.out.println(library.returnItem(member2.getId(), lah.getId(), localDateForReturn));

  library.printAllLate();

  }
}