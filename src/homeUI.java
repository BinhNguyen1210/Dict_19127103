/**
 * PACKAGE_NAME
 * Created by ThaiBinh
 * Date 12/21/2021 - 11:54 PM
 * Description: ...
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class homeUI extends JFrame implements ActionListener {
    private TextField textField;
    private Button searchSlang;
    private Button searchMean;
    private Button history;
    private Button edit;
    private Button delete;
    private Button reset;
    private Button random;
    private Button quiz;
    private JTable table;
    String[] tableLabel = {"Slang", "Meaning"};
    private DefaultTableModel mod;

    public void showMenu() {
        BoxLayout box = new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS);
        this.getContentPane().setLayout(box);

        JPanel jPanel1 = new JPanel();
        BoxLayout box1 = new BoxLayout(jPanel1, BoxLayout.Y_AXIS);
        jPanel1.setLayout(box1);

        jPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
        textField = new TextField();
        textField.setMaximumSize(new Dimension(300,300));
        textField.setPreferredSize(new Dimension(300,30));
        textField.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(textField);
        jPanel1.add(Box.createRigidArea(new Dimension(0, 10)));

        searchSlang = new Button("Search by Slang Word");
        searchSlang.setActionCommand("searchSlang");
        searchSlang.addActionListener(this);
        searchSlang.setMaximumSize(new Dimension(300,300));
        searchSlang.setPreferredSize(new Dimension(300,60));
        searchSlang.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(searchSlang);
        jPanel1.add(Box.createRigidArea(new Dimension(0, 10)));

        searchMean = new Button("Search by Meaning");
        searchMean.setActionCommand("searchMean");
        searchMean.addActionListener(this);
        searchMean.setMaximumSize(new Dimension(300,300));
        searchMean.setPreferredSize(new Dimension(300,60));
        searchMean.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(searchMean);
        jPanel1.add(Box.createRigidArea(new Dimension(0, 40)));

        history = new Button("Search history");
        history.setActionCommand("history");
        history.addActionListener(this);
        history.setMaximumSize(new Dimension(300,300));
        history.setPreferredSize(new Dimension(300,60));
        history.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(history);
        jPanel1.add(Box.createRigidArea(new Dimension(0, 10)));

        edit = new Button("Edit");
        edit.setActionCommand("edit");
        edit.addActionListener(this);
        edit.setMaximumSize(new Dimension(300,300));
        edit.setPreferredSize(new Dimension(300,60));
        edit.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(edit);
        jPanel1.add(Box.createRigidArea(new Dimension(0, 10)));

        delete = new Button("Delete");
        delete.setActionCommand("delete");
        delete.addActionListener(this);
        delete.setMaximumSize(new Dimension(300,300));
        delete.setPreferredSize(new Dimension(300,60));
        delete.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(delete);
        jPanel1.add(Box.createRigidArea(new Dimension(0, 10)));

        reset = new Button("Reset");
        reset.setActionCommand("reset");
        reset.addActionListener(this);
        reset.setMaximumSize(new Dimension(300,300));
        reset.setPreferredSize(new Dimension(300,60));
        reset.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(reset);
        jPanel1.add(Box.createRigidArea(new Dimension(0, 10)));

        random = new Button("Random");
        random.setActionCommand("random");
        random.addActionListener(this);
        random.setMaximumSize(new Dimension(300,300));
        random.setPreferredSize(new Dimension(300,60));
        random.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(random);
        jPanel1.add(Box.createRigidArea(new Dimension(0, 10)));

        quiz = new Button("Quiz");
        quiz.setActionCommand("quiz");
        quiz.addActionListener(this);
        quiz.setMaximumSize(new Dimension(300,300));
        quiz.setPreferredSize(new Dimension(300,60));
        quiz.setFont(new Font("Arial",Font.PLAIN,16));
        jPanel1.add(quiz);

        jPanel1.setBackground((Color.gray));
        this.add(jPanel1, BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.CENTER);

        mod = new DefaultTableModel(null,tableLabel);
        //mod.addRow(a);
        table = new JTable(mod);
        table.getTableHeader().setFont(new Font("Serif", Font.PLAIN,20));
        table.setFont(new Font("Serif", Font.PLAIN,17));
        table.setRowHeight(30);
        table.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.EAST);
        this.getContentPane().setBackground((Color.gray));
        setTitle("Menu");
        resize(1000, 600);
        setResizable(true);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        homeUI h = new homeUI();
        h.showMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command =e.getActionCommand();
        DictManagement dictManagement = new DictManagement();
        dictManagement.DictInitilize();
        if(command == "searchSlang"){
            mod.getDataVector().removeAllElements();
            Vector<String> list = new Vector<>();
            list = dictManagement.SearchbySlang(textField.getText());
            if (dictManagement.SearchbySlang(textField.getText()) == null)
                JOptionPane.showMessageDialog(null, "No slang found!", "Not existed", JOptionPane.INFORMATION_MESSAGE);
            else mod.addRow(list);

        }
        if(command == "searchMean"){
            mod.getDataVector().removeAllElements();
            Vector<String[]> list = new Vector<>();
            list = dictManagement.SearchbyMeaning(textField.getText());
            if (dictManagement.SearchbyMeaning(textField.getText()) == null)
                JOptionPane.showMessageDialog(null, "No meaning found!", "Not existed", JOptionPane.INFORMATION_MESSAGE);
            else{
                for(int i=0; i<list.size();i++){
                    mod.addRow(list.get(i));
                }

            }
        }
        if(command == "history"){

        }
        if(command == "edit"){

        }
        if(command == "delete"){

        }
        if(command == "reset"){

        }
        if(command == "random"){

        }
        if(command == "quiz"){

        }
    }
}