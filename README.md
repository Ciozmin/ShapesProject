A Java console application built with the **Model-View-Controller** pattern.

**Problem:** given a collection of objects shaped like cubes, spheres and cylinders, display the objects whose volume is greater than 25 cm³.

## Project structure

```
src/
├── model/        Shape (interface), Cube, Sphere, Cylinder
├── repository/   Repository (interface), ArrayRepository (fixed-size array)
├── controller/   Controller
├── view/         ConsoleView (text menu)
├── exception/    ShapeException, InvalidShapeException,
│                 RepositoryFullException, InvalidIndexException
└── app/          Main
```

| Layer | Responsibility |
|---|---|
| **Model** | The entities. Each class implements `Shape` and its `volume()` method. Constructors reject non-positive dimensions. |
| **Repository** | In-memory storage in a fixed-size `Shape[]`. Supports add, remove, get, size and getAll. |
| **Controller** | Holds a `Repository` (typed as the interface, so the implementation is replaceable). Adds and removes shapes, and returns those with volume > limit. |
| **View** | Text interface: add a cube, sphere or cylinder, remove a shape, list all, list those with volume > 25 cm³. |
| **Exceptions** | Errors are reported with exceptions instead of return codes. All extend `ShapeException` (unchecked). |

Dependencies go one way only: `view → controller → repository → model`.

## Volume formulas

| Shape | Volume |
|---|---|
| Cube | `side³` |
| Sphere | `4/3 · π · r³` |
| Cylinder | `π · r² · h` |

## Running it

**IntelliJ IDEA:** open the `ShapesProject` folder (File → Open), use JDK 17 or newer, and run `app.Main`.

**Command line:**
```bash
javac -d out $(find src -name "*.java")
java -cp out app.Main
```

`Main` first runs a hardcoded demo, then opens the interactive menu (enter `0` to exit).

## Demo data and expected output

| Shape | Volume (cm³) | Shown? |
|---|---|---|
| Cube(2) | 8.00 | no |
| Cube(3) | 27.00 | **yes** |
| Sphere(1) | 4.19 | no |
| Sphere(2) | 33.51 | **yes** |
| Cylinder(1, 5) | 15.71 | no |
| Cylinder(2, 3) | 37.70 | **yes** |
| Cube(5) | 125.00 | **yes** |

## Error handling

| Situation | Exception |
|---|---|
| Side, radius or height ≤ 0 | `InvalidShapeException` |
| Adding to a full repository | `RepositoryFullException` |
| Removing an index that doesn't exist | `InvalidIndexException` |

The view catches `ShapeException` and prints the message, so the program never crashes on bad input.
