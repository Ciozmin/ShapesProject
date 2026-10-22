package view;

import controller.Controller;
import exception.ShapeException;
import model.Cube;
import model.Cylinder;
import model.Shape;
import model.Sphere;

import java.util.Scanner;

public class ConsoleView {
    private static final double VOLUME_LIMIT = 25.0;

    private final Controller controller;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleView(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            if (!scanner.hasNextLine()) {
                break;
            }
            String option = scanner.nextLine().trim();
            try {
                switch (option) {
                    case "1" -> addCube();
                    case "2" -> addSphere();
                    case "3" -> addCylinder();
                    case "4" -> removeShape();
                    case "5" -> printAll();
                    case "6" -> printBigShapes();
                    case "0" -> running = false;
                    default -> System.out.println("Unknown option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: please enter a valid number.");
            } catch (ShapeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Bye!");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("===== Shapes =====");
        System.out.println("1. Add cube");
        System.out.println("2. Add sphere");
        System.out.println("3. Add cylinder");
        System.out.println("4. Remove shape");
        System.out.println("5. Show all shapes");
        System.out.println("6. Show shapes with volume > " + VOLUME_LIMIT + " cm3");
        System.out.println("0. Exit");
        System.out.print("> ");
    }

    private double readDouble(String label) {
        System.out.print(label + ": ");
        return Double.parseDouble(scanner.nextLine().trim());
    }

    private void addCube() {
        controller.addShape(new Cube(readDouble("Side (cm)")));
        System.out.println("Cube added.");
    }

    private void addSphere() {
        controller.addShape(new Sphere(readDouble("Radius (cm)")));
        System.out.println("Sphere added.");
    }

    private void addCylinder() {
        double r = readDouble("Radius (cm)");
        double h = readDouble("Height (cm)");
        controller.addShape(new Cylinder(r, h));
        System.out.println("Cylinder added.");
    }

    private void removeShape() {
        printAll();
        System.out.print("Index to remove: ");
        int index = Integer.parseInt(scanner.nextLine().trim());
        controller.removeShape(index);
        System.out.println("Shape removed.");
    }

    private void printAll() {
        print("All shapes", controller.getAllShapes());
    }

    private void printBigShapes() {
        print("Shapes with volume > " + VOLUME_LIMIT + " cm3",
                controller.getShapesWithVolumeGreaterThan(VOLUME_LIMIT));
    }

    public static void print(String title, Shape[] shapes) {
        System.out.println("--- " + title + " ---");
        if (shapes.length == 0) {
            System.out.println("(none)");
        }
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(i + ". " + shapes[i]);
        }
    }

    public static double getVolumeLimit() {
        return VOLUME_LIMIT;
    }
}
