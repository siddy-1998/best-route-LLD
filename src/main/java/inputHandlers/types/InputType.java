package inputHandlers.types;

import java.util.Scanner;

public interface InputType<T> {
    T handleInput(Scanner scanner);
}