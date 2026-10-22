package app;

import controller.Controller;
import exception.ShapeException;
import model.Cube;
import model.Cylinder;
import model.Sphere;
import repository.ArrayRepository;
import repository.Repository;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Repository repository = new ArrayRepository(20);
        Controller controller = new Controller(repository);

        controller.addShape(new Cube(2));
        controller.addShape(new Cube(3));
        controller.addShape(new Sphere(1));
        controller.addShape(new Sphere(2));
        controller.addShape(new Cylinder(1, 5));
        controller.addShape(new Cylinder(2, 3));
        controller.addShape(new Cube(5));

        ConsoleView.print("All shapes", controller.getAllShapes());
        ConsoleView.print("Shapes with volume > " + ConsoleView.getVolumeLimit() + " cm3",
                controller.getShapesWithVolumeGreaterThan(ConsoleView.getVolumeLimit()));

        try {
            new Cube(-1);
        } catch (ShapeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        try {
            controller.removeShape(100);
        } catch (ShapeException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\nStarting interactive menu...");
        new ConsoleView(controller).run();
    }
}
