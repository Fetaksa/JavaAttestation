package ru.geekbrains.xena;

import ru.geekbrains.xena.logic.ToyQueue;
import ru.geekbrains.xena.model.Toy;

public class Main {
    public static void main(String[] args) {
        ToyQueue toyQueue = new ToyQueue("1 constructor 2", "2 robot 2", "3 doll 6");

        toyQueue.addToQueue(new Toy(4, "car", 4));
        toyQueue.addToQueue(new Toy(5, "ball", 1.5));

        toyQueue.getAndWriteToFile(10, "result.txt");
    }
}