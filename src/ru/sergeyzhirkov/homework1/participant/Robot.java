package ru.sergeyzhirkov.homework1.participant;

import ru.sergeyzhirkov.homework1.activity.Jumping;
import ru.sergeyzhirkov.homework1.activity.Running;
import ru.sergeyzhirkov.homework1.obstacle.RunRoad;
import ru.sergeyzhirkov.homework1.obstacle.Wall;

public class Robot implements Running, Jumping {
    private String name;
    private int runLength;
    private int jumpHeight;

    public Robot(String name, int runLength, int jumpHeight) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public boolean jump(Object obstacle) {
        if (jumpHeight >= ((Wall) obstacle).getHeight()) {
            System.out.println("Робот " + name + " преодолел стену!");
            return true;
        } else {
            System.out.println("Робот " + name + " НЕ преодолел стену! и выбывает из гонки!");
            return false;
        }
    }

    @Override
    public boolean run(Object obstacle) {
        if (runLength >= ((RunRoad) obstacle).getLength()) {
            System.out.println("Робот " + name + " преодолел беговую дорожку!");
            return true;
        } else {
            System.out.println("Робот " + name + " НЕ преодолел дорожку! и выбывает из гонки!");
            return false;
        }
    }
}
