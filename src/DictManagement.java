import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

/**
 * PACKAGE_NAME
 * Created by ThaiBinh
 * Date 12/21/2021 - 8:44 PM
 * Description: ...
 */
public class DictManagement {
    private TreeMap<String, Vector<String>> dict;

    public DictManagement() {
        this.dict = new TreeMap<>();
    }

    public DictManagement(TreeMap<String, Vector<String>> dict) {
        this.dict = dict;
    }

    public void DictInitilize() {
        FileReader fr;
        String s = "";
        try {
            fr = new FileReader("test.txt");
            int data = fr.read();
            StringBuilder line = new StringBuilder();
            while (data != -1) {
                if ((char)data == '\n') {
                    String temp = s;
                    s = temp + line.toString();
                    String[] slang = s.split("`");
                    Vector<String> meaning = new Vector<>();
                    String[] arrStr = slang[1].split("\\|");
                    for (int i = 0; i < arrStr.length; i++) {
                        meaning.add(arrStr[i].trim());
                    }
                    dict.put(slang[0], meaning);
                    s = "";
                    line.delete(0, line.length());
                    data = fr.read();
                    continue;
                }
                line.append((char)data);
                data = fr.read();
            }
            fr.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ShowSlangList() {
        Set<String> tempkey = dict.keySet();
        for(String tk:tempkey){
            System.out.print(tk + " ");
            int n = dict.get(tk).size();
            for (int i = 0; i < n; i++) {
                System.out.print(dict.get(tk).get(i).toString() + " ");
            }
            System.out.println("");
        }
    }

    public void WriteToFile() {
        FileWriter fw;
        try {
            File file = new File("test.txt");
            file.delete();
            fw = new FileWriter("test.txt");
            Set<String> tempkey = dict.keySet();
            for(String tk:tempkey){
                fw.write(tk + "`");
                int n = dict.get(tk).size();
                for (int i = 0; i < n - 1; i++) {
                    fw.write(dict.get(tk).get(i).toString() + "|");
                }
                fw.write(dict.get(tk).get(n - 1).toString() + "\n");
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void AddSlangWord(String slang, String meaning, String option) {
        Set<String> tempkey = dict.keySet();
        Boolean isContain = false;
        for(String tk:tempkey) {
            if (tk.equals(slang))
                isContain = true;
        }

        Vector<String> m = new Vector<>();
        m.add(meaning);
        if (isContain == true) {
            if (option == "overwrite")
                dict.put(slang, m);
            if (option == "duplicate") {
                dict.get(slang).add(meaning);
            }
        }
        if (isContain == false) {
            dict.put(slang, m);
        }
    }

    public Vector<String> SearchbySlang(String slang) {
        Set<String> tempkey = dict.keySet();
        Vector<String> found = new Vector<>();
        for(String tk:tempkey) {
            if (tk.toLowerCase().equals(slang.toLowerCase())) {
                found.add(tk);
                found.add(dict.get(tk).toString());
                return found;
            }
        }
        return null;
    }

    public Vector<String[]> SearchbyMeaning(String meaning) {
        Set<String> tempkey = dict.keySet();
        Vector<String[]> found = new Vector<>();
        boolean k=false;
        for(String tk:tempkey) {
            if (dict.get(tk).toString().toLowerCase().contains(meaning.toLowerCase())) {
                k=true;
                String []temp=new String[2];
                temp[0]=tk;
                temp[1]=dict.get(tk).toString();
                found.add(temp);
            }
        }
        if (k == true) {
            return found;
        }
        return null;
    }
}
