import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PACKAGE_NAME
 * Created by ThaiBinh
 * Date 12/24/2021 - 12:48 PM
 * Description: ...
 */
public class randomSlangUI extends JFrame implements ActionListener {
    private TextField slang;
    private TextField definition;
    private Button back;

    @Override
    public void actionPerformed(ActionEvent e) {
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.getContentPane().setLayout(box);
        

        back = new Button("Back to homepage");
        back.setActionCommand("back");
        back.addActionListener(this);
        back.setMaximumSize(new Dimension(150,30));
        back.setPreferredSize(new Dimension(150,30));
        back.setFont(new Font("Arial",Font.PLAIN,16));

    }
}
