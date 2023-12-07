import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OgrenciKayitFormu extends JFrame {
    private JLabel ogrencikayitolusturma;
    private JTextField ogrencibolumu;
    private JTextField ogrenciad;
    private JTextField ogrencisoyad;
    private JTextField ogrencino;
    private JButton kayitbtn;
    private JComboBox comboBox1;

    public OgrenciKayitFormu() {
        JLabel ogrenciAdLabel = new JLabel("Öğrenci Adı:");
        JTextField ogrenciAdField = new JTextField(12);

        JLabel ogrenciSoyadLabel = new JLabel("Öğrenci Soyadı:");
        JTextField ogrenciSoyadField = new JTextField(12);

        JLabel ogrenciNoLabel = new JLabel("Öğrenci No:");
        JTextField ogrenciNoField = new JTextField(12);

        JLabel ogrenciBolumLabel = new JLabel("Öğrenci Bölümü:");
        JTextField ogrenciBolumField = new JTextField(12);

        JLabel ogrenciDerslerLabel = new JLabel("Öğrenci Dersleri:");
        String[] dersler = {"İşletim Sistemleri", "Görsel Programlama", "Nesneye Dayalı Programlama"};
        JComboBox<String> ogrenciDersComboBox = new JComboBox<>(dersler);

        JButton kaydetButton = new JButton("Kaydet");
        kaydetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ogrenciAd = ogrenciAdField.getText().trim();
                String ogrenciSoyad = ogrenciSoyadField.getText().trim();
                String ogrenciNo = ogrenciNoField.getText().trim();
                String ogrenciBolum = ogrenciBolumField.getText().trim();

                if (ogrenciNo.isEmpty() || ogrenciAd.isEmpty() || ogrenciSoyad.isEmpty() || ogrenciBolum.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen bilgileri eksiksiz doldurunuz.", "Hata", JOptionPane.ERROR_MESSAGE);
                } else {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("ogrenciler.csv", true))) {
                        bw.write(ogrenciNo + "," + ogrenciAd + "," + ogrenciSoyad + "," + ogrenciBolum);
                        bw.newLine();
                        System.out.println("Öğrenci kaydedildi: " + ogrenciAd);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(ogrenciAdLabel);
        panel.add(ogrenciAdField);
        panel.add(ogrenciSoyadLabel);
        panel.add(ogrenciSoyadField);
        panel.add(ogrenciNoLabel);
        panel.add(ogrenciNoField);
        panel.add(ogrenciBolumLabel);
        panel.add(ogrenciBolumField);
        panel.add(ogrenciDerslerLabel);
        panel.add(ogrenciDersComboBox);
        panel.add(new JLabel());
        panel.add(kaydetButton);

        this.add(panel);
        this.setSize(350, 300);
        this.setTitle("Öğrenci Kayıt Formu");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OgrenciKayitFormu());
    }
}
