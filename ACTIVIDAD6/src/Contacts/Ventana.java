package Contacts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ventana {
    private JTextField txtNombre;
    private JTextField txtNumero;
    private JButton btnDelate;



    private JButton btnUpdate;
    private JButton btnRead;
    private JButton btnCreate;
    public JPanel PanlePrincipal;
    private JLabel Nombre;
    private JLabel Numero;

    public Ventana() {
    btnCreate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent n) {
            try {

                String newName = String.valueOf(txtNombre.getText());

                long newNumber = Long.parseLong(txtNumero.getText());

                String nameNumberString;
                String name;
                long number;
                int index;

                File file = new File("C:\\Users\\albei\\Desktop\\POO\\friendsContact.txt");

                if (file.exists() == false) {

                    file.createNewFile();
                }

                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                boolean found = false;

                while (raf.getFilePointer() < raf.length()) {

                    nameNumberString = raf.readLine();

                    String[] lineSplit
                            = nameNumberString.split("!");

                    name = lineSplit[0];
                    number = Long.parseLong(lineSplit[1]);

                    if (name.equals(newName) || number == newNumber) {
                        found = true;
                        break;
                    }
                }

                if (found == false) {

                    nameNumberString = newName + "!" + String.valueOf(newNumber);

                    raf.writeBytes(nameNumberString);

                    raf.writeBytes(System.lineSeparator());

                    // Print the message
                    System.out.println(" Friend added. ");


                    raf.close();
                }

                else {

                    raf.close();

                    System.out.println(newName + " does exists. ");
                }
            } catch (IOException ioe) {

                System.out.println(ioe);
            } catch (NumberFormatException nef) {

                System.out.println(nef);
            }
        }
    });
    btnDelate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                String newName = String.valueOf(txtNombre.getText());

                String nameNumberString;
                String name;
                long number;
                int index;

                File file = new File("C:\\Users\\albei\\Desktop\\POO\\friendsContact.txt");

                if (!file.exists()) {

                    file.createNewFile();
                }

                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                boolean found = false;

                while (raf.getFilePointer() < raf.length()) {

                    nameNumberString = raf.readLine();

                    String[] lineSplit = nameNumberString.split("!");

                    name = lineSplit[0];
                    number = Long.parseLong(lineSplit[1]);

                    if (name.equals(newName)) {
                        found = true;
                        break;
                    }
                }

                if (found == true) {

                    File tmpFile = new File("C:\\Users\\albei\\Desktop\\POO\\temp.txt");

                    RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

                    raf.seek(0);

                    while (raf.getFilePointer() < raf.length()) {

                        nameNumberString = raf.readLine();

                        index = nameNumberString.indexOf('!');
                        name = nameNumberString.substring(0, index);

                        if (name.equals(newName)) {

                            continue;
                        }

                        tmpraf.writeBytes(nameNumberString);

                        tmpraf.writeBytes(System.lineSeparator());
                    }

                    raf.seek(0);
                    tmpraf.seek(0);

                    while (tmpraf.getFilePointer() < tmpraf.length()) {
                        raf.writeBytes(tmpraf.readLine());
                        raf.writeBytes(System.lineSeparator());
                    }

                    raf.setLength(tmpraf.length());

                    tmpraf.close();
                    raf.close();

                    tmpFile.delete();

                    System.out.println(" Friend deleted. ");
                }

                else {

                    raf.close();

                    System.out.println(newName + " does not exists. ");
                }
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }
    });
    btnUpdate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent a) {
            try {

                String newName = String.valueOf(txtNombre.getText());

                long newNumber = Long.parseLong(txtNumero.getText());

                String nameNumberString;
                String name;
                long number;
                int index;

                File file = new File("C:\\Users\\albei\\Desktop\\POO\\friendsContact.txt");

                if (!file.exists()) {

                    file.createNewFile();
                }

                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                boolean found = false;

                while (raf.getFilePointer() < raf.length()) {

                    nameNumberString = raf.readLine();

                    String[] lineSplit = nameNumberString.split("!");

                    name = lineSplit[0];
                    number = Long.parseLong(lineSplit[1]);

                    if (name.equals(newName) || number == newNumber) {
                        found = true;
                        break;
                    }
                }

                if (found == true) {

                    File tmpFile = new File("C:\\Users\\albei\\Desktop\\POO\\temp.txt");

                    RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

                    raf.seek(0);

                    while (raf.getFilePointer() < raf.length()) {

                        nameNumberString = raf.readLine();

                        index = nameNumberString.indexOf('!');
                        name = nameNumberString.substring(0, index);

                        if (name.equals(newName)) {

                            nameNumberString
                                    = name + "!" + String.valueOf(newNumber);
                        }

                        tmpraf.writeBytes(nameNumberString);

                        tmpraf.writeBytes(System.lineSeparator());
                    }

                    raf.seek(0);
                    tmpraf.seek(0);

                    while (tmpraf.getFilePointer() < tmpraf.length()) {
                        raf.writeBytes(tmpraf.readLine());
                        raf.writeBytes(System.lineSeparator());
                    }

                    raf.setLength(tmpraf.length());

                    tmpraf.close();
                    raf.close();

                    tmpFile.delete();

                    System.out.println(" Friend updated. ");
                }

                else {

                    raf.close();


                    System.out.println(newName + " does not exists. ");
                }
            } catch (IOException ioe) {
                System.out.println(ioe);
            } catch (NumberFormatException nef) {
                System.out.println(nef);
            }
        }
    });
    btnRead.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent f) {
            try {

                String nameNumberString;
                String name;
                String Newname = String.valueOf(txtNombre.getText());
                long number;
                int index = 0;

                File file = new File("C:\\Users\\albei\\Desktop\\POO\\friendsContact.txt");

                if (!file.exists()) {

                    file.createNewFile();
                }



                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                boolean found = false;

                while (raf.getFilePointer() < raf.length()) {


                    nameNumberString = raf.readLine();

                    String[] lineSplit = nameNumberString.split("!");


                    name = lineSplit[0];
                    number = Long.parseLong(lineSplit[1]);

                    if (name.equals(Newname)){
                        txtNombre.setText(String.valueOf(name));
                        txtNumero.setText(String.valueOf(number));
                        System.out.println("Friend Name: " + name + "\n"  + "Contact Number: " + number + "\n");
                        index = 1;
                    }


                }
                if (index ==0){

                    System.out.println(Newname + " does not exists. ");
                }


        } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);

            }
        }
        });
}
}

