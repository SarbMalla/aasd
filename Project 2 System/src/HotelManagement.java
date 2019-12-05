import javax.swing.*;

public class HotelManagement extends JFrame {
    public HotelManagement() {
        setTitle("My Gui");
        setSize(800, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

     // Create JButton and JPanel
        JPanel panel = new JPanel();\
        JButton CheckIn = new JButton("Check In");
        JButton CheckOut = new JButton("Check Out");
        JButton RStatus = new JButton("Room Status");
        
       this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

    	HotelManagement a = new HotelManagement();
    }
}