package org.javafrankers.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

public class ScriptRunner {
    public static void executeScript(Connection conn, String filePath) throws Exception {
        String sql = new String(Files.readAllBytes(Paths.get(filePath)));
        for (String statement : sql.split(";")) {
            String trimmed = statement.trim();
            if (!trimmed.isEmpty()) {
                conn.createStatement().execute(trimmed);
            }
        }
    }
}
