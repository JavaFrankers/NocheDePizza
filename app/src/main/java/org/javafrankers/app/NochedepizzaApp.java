package org.javafrankers.app;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.javafrankers.DataBaseConnection;
import org.javafrankers.dao.JdbcProductDao;
import org.javafrankers.util.ScriptRunner;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.*;

@AllArgsConstructor
@Log4j
public class NochedepizzaApp {
    private final Scanner scanner;
    private final JdbcProductDao jdbcProductDao;
    public void run() {
        initSQL();
        int opt = 0;
        String estado = null; // null = no hay pedido activo

        do {
            List<String> menuLines = Arrays.asList(
                    "X-=-|Noche de Pizza|-=-X",
                    "X----------------------X",
                    "1. Pedidos",
                    "2. Cliente",
                    "3. Producto",
                    "4. Salir",
                    "X----------------------X",
                    "Selecciona un opcion: "
            );

            if (estado != null && !estado.isBlank()) {
                List<String> menuLines2 = Arrays.asList(
                        "X----------------------X",
                        "X--|Estado del pedido|-X",
                        "X----------------------X",
                        "X---|" + estado + "|---X",
                        "X----------------------X",
                        "X----------------------X",
                        "X----------------------X"
                );

                int maxLines = Math.max(menuLines.size(), menuLines2.size());
                for (int i = 0; i < maxLines; i++) {
                    String menuPart = (i < menuLines.size()) ? menuLines.get(i) : "";
                    String estadoPart = (i < menuLines2.size()) ? menuLines2.get(i) : "";
                    System.out.println(String.format("%-35s %s", menuPart, estadoPart));
                }
            } else {
                menuLines.forEach(System.out::println);
            }

            // Aquí lees la opción DESPUÉS de mostrar el menú
            opt = readNumber();
            // ... parsear opt, actualizar estado según la opción elegida, etc.
            if (opt == 1){
                pedidos();
            } else if (opt == 2) {
                cliente();
            } else if (opt == 3) {
                producto();
            } else if (opt == 4) {
                System.out.println("Saliendo...");
            } else {
                log.error("Opcion erronea por favor introduzca una opcion valida");
            }
        } while (opt != 4);
    }
    private int readNumber(){
        Integer integer = null;
        do {
            try{
                integer = scanner.nextInt();
            } catch (InputMismatchException e){
                log.error("Wrong character pls use a number");
            } finally {
                scanner.nextLine();
            }
        }while (integer == null);
        return integer;
    }
    private void cliente(){
        int opt = 0;
        do {
            List<String> menuLines = Arrays.asList(
                    "X-=-|Noche de Pizza|-=-X",
                    "X-------|Cliente|------X",
                    "1. Insertar",
                    "2. Buscar por ID",
                    "3. Listar todos",
                    "4. Actualizar",
                    "5. Borrar",
                    "6. Atras",
                    "X----------------------X",
                    "Selecciona un opcion: "
            );
            menuLines.forEach(System.out::println);
            opt = readNumber();
        }while (opt != 6);
    }
    private void producto(){
        int opt = 0;
        do {
            List<String> menuLines = Arrays.asList(
                    "X-=-|Noche de Pizza|-=-X",
                    "X-------|Producto|------X",
                    "1. Insertar",
                    "2. Buscar por ID",
                    "3. Listar todos",
                    "4. Actualizar",
                    "5. Borrar",
                    "6. Atras",
                    "X----------------------X",
                    "Selecciona un opcion: "
            );
            menuLines.forEach(System.out::println);
            opt = readNumber();
        }while (opt != 6);
    }
    private void pedidos(){
        int opt = 0;
        do {
            List<String> menuLines = Arrays.asList(
                    "X-=-|Noche de Pizza|-=-X",
                    "X-------|Pedido|------X",
                    "1. Crear pedido",
                    "2. Borrar pedido",
                    "3. Cambiar estado",
                    "4. Atras",
                    "X----------------------X",
                    "Selecciona un opcion: "
            );
            menuLines.forEach(System.out::println);
            opt = readNumber();
        }while (opt != 4);
    }
    private void initSQL(){
        try (Connection conn = DataBaseConnection.getConnection()) {
            ScriptRunner.executeScript(conn, "src/main/resources/init.sql");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
