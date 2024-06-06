package finisu;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GUI {

    public static void main(String[] args){

        ImageIcon image = new ImageIcon("resources\\garf.png");
        JLabel label = new JLabel();

        Border border = BorderFactory.createLineBorder(Color.red, 5);

        label.setText("Vão se foderem");
        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setForeground(Color.red);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        label.setIconTextGap(5);
        label.setBackground(Color.orange);
        label.setOpaque(true);
        label.setBorder(border);

        JFrame frame = new JFrame("Teste");
        frame.setTitle("Teste");
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setVisible(true);
    }
}