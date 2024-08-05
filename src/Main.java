import javax.swing.*;
import java.util.*;

public class Main {

    static ArrayList<Hotel> hotels = new ArrayList<>();
    static int sizeOfHotels = 0;
    static HashMap <String, ArrayList<String> > reviewsMap ;
    public static void main(String[] args) {

        reviewsMap = new HashMap<>();
        show();
    }
    public static void show()
    {
        while (true) {
            String data =
                    "1. Add a new hotel \n" +
                    "2. show hotel details\n"+
                    "3. Add a new review to the hotel\n" +
                    "4. show the reviews for the hotel\n" +
                    "5. Exit the program \n" +
                    "Enter your choice : \n";

            String choice = JOptionPane.showInputDialog(null, data);
            int cho = Integer.parseInt(choice);
            switch (cho) {
                case 1:
                    addPlace();
                    break;
                case 2:
                    showHotel();
                    break;
                case 3:
                    addReviewToHotel();
                    break;
                case 4:
                    showReview();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Your choice is Wrong ");
                    break;
            }
        }
    }
    public static void addPlace()
    {
      int ou= -1;
       do {

       JTextField name = new JTextField();
       JTextField number = new JTextField();
       JTextField address = new JTextField();

       Object [] data = {
                "Name : " , name,
                "Address : ", address,
                "Number : ", number
        };
        int yN = JOptionPane.showConfirmDialog(null,data); // yes == 0 : no == 1

        if (yN == JOptionPane.YES_OPTION) {
            String n = name.getText();
            String adrs = address.getText();
            int num = Integer.parseInt(number.getText());

            int search = searchNum(num);

            if (search == -1) {
                hotels.add(new Hotel(num, n, adrs));
                sizeOfHotels++;
                JOptionPane.showMessageDialog(null, "The Hotel has been added");

            } else {
                JOptionPane.showMessageDialog(null, "The Hotel exists before");
            }
        }
            String answer = JOptionPane.showInputDialog(null,"Do you want add another Hotel (1/0): ");
            ou = Integer.parseInt(answer);
       } while (ou == 1);
    }
    public static void showHotel()
    {
        int show = showHotels();
        String data =
                "\n Name : "+hotels.get(show-1).getName() +
                "\n Address : "+hotels.get(show-1).getAddress()+
                "\n Number : "+hotels.get(show-1).getNumberphone();

        JOptionPane.showMessageDialog(null,data);
    }
    public static int searchNum(int num) // yes == -1
    {
        for (int i = 0 ;i < sizeOfHotels;i++)
        {
            if (hotels.get(i).getNumberphone() == num)
            {
                return i;
            }
        }
        return -1;
    }
    public static int showHotels()
    {
        String data = "";
        for (int i = 0 ; i < sizeOfHotels;i++)
        {
            data += (i+1)+ "- " + hotels.get(i).getName()+"\n";
        }
        String in = JOptionPane.showInputDialog(null, data);
        int ou = Integer.parseInt(in);
        return ou;
    }

    public static void addReviewToHotel()
    {
        int ou = -1;
        do {
            int in = showHotels(); // 0 -> 1
            String hotel = hotels.get(in-1).getName();
            String data = hotel + " Hotel"+
                    "\n5. Add 5 Stars"+
                    "\n4. Add 4 Stars"+
                    "\n3. Add 3 Stars"+
                    "\n2. Add 2 Stars"+
                    "\n1. Add 1 Stars";
            String choose = JOptionPane.showInputDialog(null,data);
            int ch = Integer.parseInt(choose); // 5 4 3 2 1
             String stars = ch + " Stars"+
                    "\n Enter your comment : " ;
            String comment = ch + " Stars : "+ JOptionPane.showInputDialog(null,stars );
            reviewsMap.putIfAbsent(hotel,new ArrayList<>());
            reviewsMap.get(hotel).add(comment);

            String answer = JOptionPane.showInputDialog(null,"Do you want add another review (1/0) : ");
            ou = Integer.parseInt(answer);

        }while (ou == 1);
    }
    public static void showReview()
    {

        int sh = showHotels(); // 1
        String hotel = hotels.get(sh-1).getName();
        String review = String.valueOf(reviewsMap.getOrDefault(hotel, new ArrayList<>()));
        JOptionPane.showMessageDialog(null,review);
    }


}
