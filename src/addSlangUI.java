import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.BitSet;

/**
 * PACKAGE_NAME
 * Created by ThaiBinh
 * Date 12/23/2021 - 12:54 AM
 * Description: ...
 */
public class addSlangUI extends JFrame implements ActionListener {
    private TextField textFieldS;
    private TextField textFieldM;
    private Button add;
    private Button back;
    private Label label1;
    private Label label2;

    public void showAddbox() {
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.getContentPane().setLayout(box);

        JPanel jPanel1 = new JPanel();
        BoxLayout box1 = new BoxLayout(jPanel1, BoxLayout.X_AXIS);
        jPanel1.setLayout(box1);
        add = new Button("Add slang word");
        add.setActionCommand("add");
        add.addActionListener(this);
        add.setMaximumSize(new Dimension(200,40));
        add.setPreferredSize(new Dimension(200,40));
        add.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(add);
        jPanel1.setBackground(Color.gray);
        jPanel1.add(Box.createRigidArea(new Dimension(30, 10)));

        back = new Button("Back to homepage");
        back.setActionCommand("back");
        back.addActionListener(this);
        back.setMaximumSize(new Dimension(200,40));
        back.setPreferredSize(new Dimension(200,40));
        back.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(back);

        JPanel jPanel2 = new JPanel();
        BoxLayout box2 = new BoxLayout(jPanel2, BoxLayout.Y_AXIS);
        jPanel2.setLayout(box2);
        jPanel2.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel2.add(jPanel1);
        jPanel2.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel2.setBackground(Color.gray);

        label1 = new Label("Slang word:");
        label1.setFont(new Font("Arial",Font.PLAIN,18));
        label2 = new Label("Meaning:");
        label2.setFont(new Font("Arial",Font.PLAIN,18));

        textFieldS = new TextField();
        textFieldS.setMaximumSize(new Dimension(300,30));
        textFieldS.setPreferredSize(new Dimension(300,30));
        textFieldS.setFont(new Font("Arial",Font.PLAIN,16));
        textFieldM = new TextField();
        textFieldM.setMaximumSize(new Dimension(300,30));
        textFieldM.setPreferredSize(new Dimension(300,30));
        textFieldM.setFont(new Font("Arial",Font.PLAIN,16));

        JPanel jPanel3 = new JPanel();
        BoxLayout box3 = new BoxLayout(jPanel3, BoxLayout.X_AXIS);
        jPanel3.setLayout(box3);
        jPanel3.add(Box.createRigidArea(new Dimension(50, 10)));
        jPanel3.add(label1);
        jPanel3.add(textFieldS);
        jPanel3.add(Box.createRigidArea(new Dimension(50, 10)));
        jPanel3.setBackground(Color.gray);

        JPanel jPanel4 = new JPanel();
        BoxLayout box4 = new BoxLayout(jPanel4, BoxLayout.X_AXIS);
        jPanel4.setLayout(box4);
        jPanel4.add(Box.createRigidArea(new Dimension(50, 10)));
        jPanel4.add(label2);
        jPanel4.add(textFieldM);
        jPanel4.add(Box.createRigidArea(new Dimension(50, 10)));
        jPanel4.setBackground(Color.gray);

        this.add(jPanel3, BorderLayout.PAGE_START);
        this.add(jPanel4, BorderLayout.CENTER);
        this.add(jPanel2, BorderLayout.PAGE_END);
        this.getContentPane().setBackground((Color.gray));
        setTitle("Add new slang word");
        resize(600, 200);
        setResizable(true);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        DictManagement dictManagement = new DictManagement();
        if(command == "add"){

        }
        if(command == "back") {
            this.dispose();
            homeUI h = new homeUI();
            h.showMenu();
        }
    }
}
