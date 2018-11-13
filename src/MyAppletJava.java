import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MyAppletJava extends Applet implements ActionListener {
    Label enterText;
    TextField text;

    Label enterKey;
    TextField key;

    Button encrypt;
    Button decrypt;

    Label result_text;
    Label result;

    public void init() {
        enterText = new Label("Enter Text: ");
        text = new TextField(25);

        enterKey = new Label("Enter key: ");
        key = new TextField(25);

        encrypt = new Button("Encrypt Text");
        decrypt = new Button("Decrypt Text");

        result_text = new Label("Resultant Text: ");
        result = new Label();

        result_text.setFont(new Font("Serif",Font.ITALIC,20));
        result.setFont(new Font("Serif",Font.BOLD,30));

        add(enterText);
        add(text);
        add(enterKey);
        add(key);

        add(encrypt);
        encrypt.addActionListener(this);
        add(decrypt);
        decrypt.addActionListener(this);

        add(result_text);
        add(result);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == encrypt) {
            String pt = text.getText();
            String k = key.getText();
            int encrypt_key = Integer.parseInt(k);

            String res = encrypt(pt, encrypt_key);
            result.setText(res);
        } else if (ae.getSource() == decrypt) {
            String ct = result.getText();
            String k = key.getText();
            int decrypt_key = Integer.parseInt(k);

            String res = decrypt(ct, decrypt_key);
            result.setText(res);
        }
    }

    private String encrypt(String pt, int key) {

        char[] chars = pt.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ key);
        }

        return new String(chars);
    }

    private String decrypt(String pt, int key) {

        char[] chars = pt.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ key);
        }

        return new String(chars);
    }

}
