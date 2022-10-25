package com.company;

import java.util.ArrayList;

public class Port {

    public static void Origin() {

        Udregn Mombasa = new Udregn(2500, 7000);
        Mombasa.containerAmount();
        Udregn DarEsSalaam = new Udregn(10000, 5000);
        DarEsSalaam.containerAmount();
        Udregn JawaharlalNehru = new Udregn(4000, 3000);
        JawaharlalNehru.containerAmount();
        Udregn TanjungPelepas = new Udregn(24000, 5000);
        TanjungPelepas.containerAmount();
        Udregn Zanzibar = new Udregn(0, 2000);
        Zanzibar.containerAmount();
        Udregn Salalah = new Udregn(0, 9000);
        Salalah.containerAmount();
        Udregn JebelAliDubai = new Udregn(0, 9500);
        JebelAliDubai.containerAmount();

        ArrayList<Integer> portArray = new ArrayList<>();

        portArray.add(0, Mombasa.containerAmount());
        portArray.add(1, DarEsSalaam.containerAmount());
        portArray.add(2, JawaharlalNehru.containerAmount());
        portArray.add(3, TanjungPelepas.containerAmount());
        portArray.add(4, Zanzibar.containerAmount());
        portArray.add(5, Salalah.containerAmount());
        portArray.add(6, JebelAliDubai.containerAmount());


        int n = portArray.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (portArray.get(j) < (portArray.get(j + 1))) {
                    int h = portArray.get(j);
                    portArray.set(j, portArray.get(j + 1));
                    portArray.set(j + 1, h);
                }
            }
        }
        ArrayList<String> nameArray = new ArrayList<>();

        nameArray.add(portArray.indexOf(JebelAliDubai.containerAmount()), "JebelAliDubai");
        nameArray.add(portArray.indexOf(Salalah.containerAmount()), "Salalah");
        nameArray.add(portArray.indexOf(Mombasa.containerAmount()), "Mombasa");
        nameArray.add(portArray.indexOf(Zanzibar.containerAmount()), "Zanzibar");
        nameArray.add(portArray.indexOf(JawaharlalNehru.containerAmount()), "JawarhalNehru");
        nameArray.add(portArray.indexOf(DarEsSalaam.containerAmount()), "DarEsSalaam");
        nameArray.add(portArray.indexOf(TanjungPelepas.containerAmount()), "TanjungPelepas");


        System.out.println("Listen efter sortering: ");
        System.out.println(portArray);
        int i = 0;
        int j = portArray.size() - 1;

        while (i != j && i <= portArray.size() / 2) {
            if (portArray.get(i) > 0 && portArray.get(j) < 0) {

                if (portArray.get(i) < portArray.get(j) * (-1)) { // Hvis der er plads til at sende

                    System.out.println(nameArray.get(i) + " sender: " + portArray.get(i) + " containers til " + nameArray.get(j));

                    portArray.set(j, portArray.get(j) + portArray.get(i));
                    portArray.set(i, portArray.get(i) - portArray.get(i));
                }

                if (portArray.get(i) >= portArray.get(j) * (-1)) { // hvis der ikke plads til at sende

                    System.out.println(nameArray.get(i) + " sender: " + (portArray.get(j) * (-1)) + " container til " + nameArray.get(j));

                    portArray.set(i, portArray.get(i) - (portArray.get(j) * (-1)));
                    portArray.set(j, portArray.get(j) + (portArray.get(j) * (-1)));
                }

                if (portArray.get(i) == 0) {
                    i++;
                }
                if (portArray.get(j) == 0) {
                    j--;
                }
            }
            System.out.println(portArray);
        }
        System.out.println("all ports are back til origins");
    }
}

class Udregn {
    private int shippedContainers;
    private int receivedContainers;

    public Udregn(int shippedContainers, int receivedContainers) {
        this.shippedContainers = shippedContainers;
        this.receivedContainers = receivedContainers;
    }

    public int containerAmount() {
        int n = receivedContainers - shippedContainers;
        return n;
    }

    public int containerSurplus() {
        int m = containerAmount() - shippedContainers;
        return m;
    }



    public int getShippedContainers() {
        return shippedContainers;

    }

    public int getReceivedContainers() {
        return receivedContainers;
    }
}
