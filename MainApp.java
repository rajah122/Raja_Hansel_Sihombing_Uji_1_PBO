abstract class Vehicle {
    // Method abstrak yang harus diimplementasikan oleh subclass
    public abstract void startEngine();
}

// Kelas Car yang mewarisi Vehicle dan mengimplementasikan Electric
class Car extends Vehicle implements Electric {
    // Implementasi method startEngine untuk Car
    @Override
    public void startEngine() {
        System.out.println("Mobil dinyalakan dengan suara mesin yang halus.");
    }

    // Implementasi method chargeBattery dari interface Electric
    @Override
    public void chargeBattery() {
        System.out.println("Baterai mobil yang diisi.");
    }
}

// Kelas Motorcycle 
class Motorcycle extends Vehicle {
    // Implementasi method startEngine untuk Motorcycle
    @Override
    public void startEngine() {
        System.out.println("Motor dinyalakan dengan suara mesin yang bertenaga.");
    }
}

// Interface Electric yang menggunakan method chargeBattery
interface Electric {
    void chargeBattery();
}

// Kelas utama untuk mendemonstrasikan polymorphism
public class MainApp {
    public static void main(String[] args) {
        // Membuat objek dari kelas Car dan Motorcycle
        Vehicle myCar = new Car();
        Vehicle myMotorcycle = new Motorcycle();

        // Memanggil method startEngine menggunakan polymorphism
        myCar.startEngine(); // Output: Mobil dinyalakan dengan suara mesin yang halus.
        myMotorcycle.startEngine(); // Output: Motor dinyalakan dengan suara mesin yang bertenaga.

        // Memeriksa apakah myCar adalah instance dari Car
        if (myCar instanceof Car) {
            // Menggunakan casting untuk memanggil method chargeBattery
            ((Car) myCar).chargeBattery(); // Output: Baterai mobil sedang diisi.
        }
    }
}
