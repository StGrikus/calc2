import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {

   private JButton numbers[] = new JButton[10];
   private Font font = new Font("Oswald", Font.BOLD, 40);
   private JTextField output = new JTextField();
   private JButton backspace = new JButton("<-"), equ = new JButton("=");
   private JButton plus = new JButton("+"), minus = new JButton("-"), multi = new JButton("*"), div = new JButton("/");

    public Panel() {
        setLayout(null);
        setFocusable(true);
        grabFocus();

        backspace.setBounds(20, 420, 80, 80);
        backspace.setFont(font);
        add(backspace);

        plus.setBounds(320, 120, 80, 80);
        plus.setFont(font);
        add(plus);

        minus.setBounds(320, 220, 80, 80);
        minus.setFont(font);
        add(minus);

        multi.setBounds(320, 320, 80, 80);
        multi.setFont(font);
        add(multi);

        div.setBounds(320, 420, 80, 80);
        div.setFont(font);
        add(div);

        equ.setBounds(220, 420, 80, 80);
        equ.setFont(font);
        add(equ);

        numbers[0] = new JButton("0");
        numbers[0].setBounds(120, 420, 80, 80);
        numbers[0].setFont(font);
        add(numbers[0]);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                numbers[x * 3 + y + 1] = new JButton((x * 3 + y + 1) + " ");
                numbers[x * 3 + y + 1].setBounds(x * (80 + 20) + 20, y * (80 + 20) + 120, 80, 80);
                numbers[x * 3 + y + 1].setFont(font);
                add(numbers[x * 3 + y + 1]);
            }
        }
        output.setBounds(20, 20, 380, 80);
        output.setFont(font);
        output.setEditable(false);
        add(output);

        ActionListener l = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            output.setText(output.getText() + b.getText());
        };

        for(JButton b : numbers){
            b.addActionListener(l);
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();

                if(!Character.isDigit(symbol))
                    return;

                output.setText(output.getText() + symbol);
            }
        });

    }
}
