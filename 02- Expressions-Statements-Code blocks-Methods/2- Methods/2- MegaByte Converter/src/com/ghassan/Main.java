package com.ghassan;

public class Main {
    //The MegaByte Converter example is described in the description text file
    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(3000);
        printMegaBytesAndKiloBytes(-232);
        printMegaBytesAndKiloBytes(400023);
        printMegaBytesAndKiloBytes(-121);
        printMegaBytesAndKiloBytes(24240);
    }

    //This method convert the KiloByte into MegaByte and print it
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else if (kiloBytes < 1024) {
            System.out.println(kiloBytes + " KB = " + "0 MB and " + kiloBytes + " KB");
        } else {
            int megaBytes = kiloBytes / 1024;
            int newKiloBytes = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + newKiloBytes + " KB");
        }
    }
}
