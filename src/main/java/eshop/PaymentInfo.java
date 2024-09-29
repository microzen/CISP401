package eshop;

import java.util.Scanner;

public class PaymentInfo {
    String cardNumber;
    String name;
    int cvv;
    String address;

    PaymentInfo(String cardNumber, String name, int cvv, String address) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
        this.address = address;
    }

    public String getNumber() {
        return this.cardNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getCVV() {
        return this.cvv;
    }

    public void setNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    static PaymentInfo promptForInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Card Number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter CVV: ");
        Integer cvv = scanner.nextInt();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        return new PaymentInfo(cardNumber, name, cvv, address);
    }
}
