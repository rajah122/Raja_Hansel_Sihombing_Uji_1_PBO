// Interface untuk fitur pengingat dengan suara adzan
interface AudioReminder {
    void playAdzan();
}

// Kelas abstrak Prayer yang menjadi dasar semua jadwal sholat
abstract class Prayer {
    private String name;
    private String time;

    // Konstruktor menginisialisasi nama dan waktu sholat
    public Prayer(String name, String time) {
        this.name = name;
        this.time = time;
    }

    // Getter nama sholat
    public String getName() {
        return name;
    }

    // Getter waktu sholat
    public String getTime() {
        return time;
    }

    // Method abstrak untuk pengingat yang harus diimplementasi di subclass
    public abstract void remind();
}

// Subclass Fajr, mengimplementasikan AudioReminder
class Fajr extends Prayer implements AudioReminder {
    public Fajr(String time) {
        super("Subuh (Fajr)", time);
    }

    @Override
    public void remind() {
        System.out.println("Waktunya " + getName() + " pukul " + getTime() + "! Saatnya bangun dan sholat Subuh.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar suara adzan Subuh...");
    }
}

// Subclass Dhuhr, mengimplementasikan AudioReminder
class Dhuhr extends Prayer implements AudioReminder {
    public Dhuhr(String time) {
        super("Dzuhur (Dhuhr)", time);
    }

    @Override
    public void remind() {
        System.out.println("Waktunya " + getName() + " pukul " + getTime() + "! Jangan lupa sholat Dzuhur tepat waktu.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar suara adzan Dzuhur...");
    }
}

// Subclass Asr, mengimplementasikan AudioReminder
class Asr extends Prayer implements AudioReminder {
    public Asr(String time) {
        super("Ashar (Asr)", time);
    }

    @Override
    public void remind() {
        System.out.println("Waktunya " + getName() + " pukul " + getTime() + "! Saatnya menunaikan sholat Ashar.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar suara adzan Ashar...");
    }
}

// Subclass Maghrib, mengimplementasikan AudioReminder
class Maghrib extends Prayer implements AudioReminder {
    public Maghrib(String time) {
        super("Maghrib", time);
    }

    @Override
    public void remind() {
        System.out.println("Waktunya " + getName() + " pukul " + getTime() + "! Segera sholat Maghrib.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar suara adzan Maghrib...");
    }
}

// Subclass Isha, mengimplementasikan AudioReminder
class Isha extends Prayer implements AudioReminder {
    public Isha(String time) {
        super("Isya (Isha)", time);
    }

    @Override
    public void remind() {
        System.out.println("Waktunya " + getName() + " pukul " + getTime() + "! Jangan lupa sholat Isya.");
    }

    @Override
    public void playAdzan() {
        System.out.println("Memutar suara adzan Isya...");
    }
}

// Kelas utama untuk mendemonstrasikan jadwal sholat dan fitur adzan
public class PrayerScheduleApp {
    public static void main(String[] args) {
        // Membuat array jadwal sholat menggunakan polymorphism
        Prayer[] prayers = new Prayer[] {
            new Fajr("04:30"),
            new Dhuhr("12:00"),
            new Asr("15:30"),
            new Maghrib("18:05"),
            new Isha("19:30")
        };

        // Menampilkan pengingat dan memutar adzan untuk setiap jadwal sholat
        for (Prayer prayer : prayers) {
            prayer.remind();

            // Cek apakah sholat memiliki audio reminder
            if (prayer instanceof AudioReminder) {
                ((AudioReminder) prayer).playAdzan();
            }

            System.out.println(); // baris kosong sebagai pemisah antar jadwal
        }
    }
}
