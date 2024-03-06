package populate;

import database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DatabasePopulateService {

    private PreparedStatement createSt;
    private Connection conn;
    public DatabasePopulateService(Database database) {
        conn = database.getConnection();
    }

    public void createNewWorker(String name, LocalDate birthday, String level, int salary) {
        try {
            createSt = conn.prepareStatement(
                    "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)"
            );
            createSt.setString(1, name);
            createSt.setString(2, birthday.toString());
            createSt.setString(3, level);
            createSt.setInt(4, salary);
            createSt.addBatch();
            createSt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createNewClient(String name) {
        try {
            createSt = conn.prepareStatement(
                    "INSERT INTO client (name) VALUES (?)"
            );
            createSt.setString(1, name);
            createSt.addBatch();
            createSt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createNewProject(int clientId, LocalDate startDate, LocalDate finishDate) {
        try {
            createSt = conn.prepareStatement(
                    "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)"
            );
            createSt.setInt(1, clientId);
            createSt.setString(2, startDate.toString());
            createSt.setString(3, finishDate.toString());
            createSt.addBatch();
            createSt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void createNewProjectWorker(int projectId, int workerId) {
        try {
            createSt = conn.prepareStatement(
                    "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)"
            );
            createSt.setInt(1, projectId);
            createSt.setInt(2, workerId);

            createSt.addBatch();
            createSt.executeBatch();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
