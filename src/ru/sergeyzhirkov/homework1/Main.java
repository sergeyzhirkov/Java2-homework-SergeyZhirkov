package ru.sergeyzhirkov.homework1;

import ru.sergeyzhirkov.homework1.activity.Jumping;
import ru.sergeyzhirkov.homework1.activity.Running;
import ru.sergeyzhirkov.homework1.obstacle.RunRoad;
import ru.sergeyzhirkov.homework1.obstacle.Wall;
import ru.sergeyzhirkov.homework1.participant.Cat;
import ru.sergeyzhirkov.homework1.participant.Human;
import ru.sergeyzhirkov.homework1.participant.Robot;

public class Main {
    public static void main(String[] args) {

        Object[] participants = {
                new Human("Sergey", 20, 5),
                new Cat("Tim", 100, 10),
                new Robot("Fedor", 30, 1)
        };

        Object[] obstacles = {
                new RunRoad(10),
                new Wall(3),
                new RunRoad(20),
                new Wall(4),
                new RunRoad(50),
                new Wall(7)
        };

        for (Object participant : participants) {
            boolean check;
            for (Object obstacle : obstacles) {
                if (obstacle instanceof RunRoad) {
                    check = ((Running) participant).run(obstacle);
                } else {
                    check = ((Jumping) participant).jump(obstacle);
                }
                if (!check) {
                    break;
                }
            }
        }
    }
}
