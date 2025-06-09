package org.example.CC;

public class Shifr {

    char[] word;
    int shift;
    private final String RUS_LOW = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final String RUS_UP = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public Shifr(char[] word, int shift) {
        this.word = word;
        this.shift = shift;
    }

    public String shifrWord() {
        for (int i = 0; i < word.length; i++) {
            if (word[i] >= Bounder.engUpperBound1.getValue() && word[i] <= Bounder.engUpperBound2.getValue()) { //English upper case
                word[i] = changeChar(Bounder.engUpperBound1.getValue(), Bounder.engUpperBound2.getValue(), word[i]);
            }
            if (word[i] >= Bounder.engLowBound1.getValue() && word[i] <= Bounder.engLowBound2.getValue()) { //English low case
                word[i] = changeChar(Bounder.engLowBound1.getValue(), Bounder.engLowBound2.getValue(), word[i]);
            }
            if ((word[i] >= Bounder.rusUpperBound1.getValue() && word[i] <= Bounder.rusUpperBound2.getValue()) || word[i] =='Ё') { //Russian upper case
                word[i] = changeRus(word[i], RUS_UP);
            }
            if ((word[i] >= Bounder.rusLowBound1.getValue() && word[i] <= Bounder.rusLowBound2.getValue()) || word[i] =='ё') { //Russian low case
                word[i] = changeRus(word[i], RUS_LOW);
            }

        }
        return new String(word);
    }


    private char changeChar(int minBound, int maxBound, char ch) {
        char newCh;
        if (((int) (ch) + shift) > maxBound) {
            int diff = ((int) (ch) + shift) - maxBound;
            newCh = (char) (minBound + diff - 1);

        } else if (((int) (ch) + shift) < minBound) {
            int diff = minBound - ((int) (ch) + shift);
            newCh = (char) (maxBound - diff + 1);
            } else {
            newCh = (char) (ch + shift);
        }
        return newCh;
    }

    private char changeRus(char ch, String rus) {
        int minBound = 0;
        int maxBound = 32;
        char newCh;
        int indexChar = rus.indexOf(ch);
        int indexNewChar = indexChar + shift;
        if (indexNewChar > maxBound) {
            int diff = indexNewChar - maxBound;
            indexNewChar = diff + minBound -1;
        } else if (indexNewChar < minBound) {
            int diff =  minBound - indexNewChar;
            indexNewChar = maxBound - diff + 1;
        }
        newCh = rus.charAt(indexNewChar);
        return newCh;
    }

}


