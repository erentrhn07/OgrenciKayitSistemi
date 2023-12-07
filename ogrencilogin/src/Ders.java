import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ders implements Serializable {
    private String dersAd;
    private String dersKredi;
    private String dersDonem;

    public Ders(String dersAd, String dersKredi) {
        this.dersAd = dersAd;
        this.dersKredi = dersKredi;
    }
    public String getDersAd() {
        return dersAd;
    }
    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }
    public String getDersKredi() {
        return dersKredi;
    }
    public void setDersKredi(String dersKredi) {
        this.dersKredi = dersKredi;
    }
    public String getDersDonem() {
        return dersDonem;
    }
    public void setDersDonem(String dersDonem) {
        this.dersDonem = dersDonem;
    }

    public static void main(String[] args) {
        List<Ders> ozelDersListesi = ozelDersListesiOlustur();

        for (Ders ders : ozelDersListesi) {
            System.out.println("Ders Adı :" + ders.getDersAd() + ", Ders Kredisi: " + ders.getDersKredi() + ", Ders Dönemi: " + ders.getDersDonem());
        }
    }
    public static List<Ders> ozelDersListesiOlustur() {
        List<Ders> dersListesi = new ArrayList<>();

        Ders ders1 = new Ders("İşletim Sistemleri", "5");
        ders1.setDersDonem("Bahar");

        Ders ders2 = new Ders("Görsel Programlama", "4");
        ders2.setDersDonem("Güz");

        Ders ders3 = new Ders("Nesneye Dayalı Programlama", "3");
        ders3.setDersDonem("Yaz");

        dersListesi.add(ders1);
        dersListesi.add(ders2);
        dersListesi.add(ders3);

        return dersListesi;
    }
}