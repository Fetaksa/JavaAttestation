package ru.geekbrains.xena.logic;

import ru.geekbrains.xena.model.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyQueue {
    private PriorityQueue<Toy> queue;

    public ToyQueue(String toy1, String toy2, String toy3) {
        queue = new PriorityQueue<>((t1, t2) -> Double.compare(t2.getWeight(), t1.getWeight()));

        String[] toys = toy1.split(" ");
        queue.add(new Toy(Integer.parseInt(toys[0]), toys[1], Double.parseDouble(toys[2])));

        toys = toy2.split(" ");
        queue.add(new Toy(Integer.parseInt(toys[0]), toys[1], Double.parseDouble(toys[2])));

        toys = toy3.split(" ");
        queue.add(new Toy(Integer.parseInt(toys[0]), toys[1], Double.parseDouble(toys[2])));
    }

    public void addToQueue(Toy toy) {
        queue.add(toy);
    }

    public void getAndWriteToFile(int times, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            for (int i = 0; i < times; i++) {
                double random = Math.random();
                if (random <= 0.2) {
                    if (queue.isEmpty()) {
                        break;
                    }
                    writer.write(queue.peek().getId() + "\n");
                } else if (random <= 0.4) {
                    Toy[] toys = queue.toArray(new Toy[0]);
                    writer.write(toys[1].getId() + "\n");
                } else {
                    Toy[] toys = queue.toArray(new Toy[0]);
                    writer.write(toys[2].getId() + "\n");
                }
            }
        } catch (IOException ex) {
            System.out.println("Error writing to file:" + ex.getMessage());
        }
    }
}

