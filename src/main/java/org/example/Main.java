package org.example;

import org.example.AEE.InToPost;
import org.example.AEE.ParsePost;
import org.example.CC.Shifr;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("Welcome to Gehtsoft Technical Assessment\n" +
                    "Please choose an option (enter number):");
            System.out.println("1. Caesar Cipher\n" +
                    "2. Arithmetic Expression Evaluation\n" +
                    "3. Exit");
            String input = sc.nextLine();
            String input2 = null;
            if (!input.equals("3")) {
                System.out.println("Select an option:\n" +
                        "1. Read from file\n" + "2. Read from console");
                input2 = sc.nextLine();
            }

            switch (input) {
                case "1":
                    if (input2.equals("1")) {
                        File file = new File(readInput());
                        ArrayList<String> array = readData(file);
                        System.out.println(readArray(array));
                        break;
                    } else {
                        String word = sc.nextLine();
                        int shift = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Select mode: 1.Encryption or 2. Decryption");
                        String mode = sc.nextLine();
                        char[] chars = word.toCharArray();

                        switch (mode) {
                            case "1":
                                Shifr encrypt = new Shifr(chars, shift);
                                System.out.println(encrypt.shifrWord());
                                break;
                            case "2":
                                Shifr decrypt = new Shifr(chars, -shift);
                                System.out.println(decrypt.shifrWord());
                                break;
                            default:
                                System.out.println("Invalid mode");
                        }
                        break;
                    }
                case "2":
                    if (input2.equals("1")) {
                        File file2 = new File(readInput());
                        ArrayList<String> array = readData(file2);
                        System.out.println(readArrayAEE(array));
                        break;
                    } else {
                        System.out.println("Enter Arithmetic Expression");
                        String ae = sc.nextLine();
                        InToPost inToPost = new InToPost(ae);
                        String trans = inToPost.doTrans();
                        ParsePost parsePost = new ParsePost(trans);
                        System.out.println(parsePost.doParse());
                        break;
                    }
                case "3":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input");

            }
        }



    }

    public static double readArrayAEE(ArrayList<String> array) {
        String aee = array.get(0);
        InToPost inToPost = new InToPost(aee);
        String trans = inToPost.doTrans();
        ParsePost parsePost = new ParsePost(trans);
        return parsePost.doParse();
    }

    public static String readArray(ArrayList<String> array) {
        char[] word = array.get(0).toCharArray();
        int shift = Integer.parseInt(array.get(1));
        String mode = array.get(2);
        if (mode.equals("encryption")) {
            Shifr encrypt = new Shifr(word, shift);
            return encrypt.shifrWord();
        } else if (mode.equals("decryption")) {
            Shifr decrypt = new Shifr(word, -shift);
            return decrypt.shifrWord();
        } else {
            return ("Invalid mode");
        }
    }


    public static String readInput() {
        System.out.println("Enter path to file");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.isEmpty() || s == null) {
            throw new NullPointerException("For using program enter path to text file");
        } else return s;

    }

    public static ArrayList<String> readData(File file) {
        ArrayList<String> arrayList = new ArrayList<>();

        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                arrayList.add(i, line);
                i++;
            }
            br.close();
            fr.close();
            return arrayList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "Impossible to read file");
        } catch (IOException e) {
            throw new RuntimeException(e + "Impossible to read file");
        }
    }
}