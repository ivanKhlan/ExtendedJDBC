package requests;

import database.Database;
import initclasses.*;
import prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

public class DatabaseQueryService {

    Database database = Database.getInstance();

    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        try {
            String sql = String.join("\n",
                    Files.readAllLines(
                            Paths.get(
                                    new Prefs()
                                            .getString(
                                                    Prefs.MAX_PROJECTS_CLIENT)))
            );
            return database.findMaxProjectsClient(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LongestProject> findLongestProject() throws SQLException {
        try {
            String sql = String.join("\n",
                    Files.readAllLines(
                            Paths.get(
                                    new Prefs()
                                            .getString(
                                                    Prefs.LONGEST_PROJECT)))
            );
            return database.findLongestProject(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaxSalaryWorkersCount> findMaxSalaryWorkers() throws SQLException {
        try {
            String sql = String.join("\n",
                    Files.readAllLines(
                            Paths.get(
                                    new Prefs()
                                            .getString(
                                                    Prefs.MAX_SALARY_WORKERS)))
            );
            return database.findMaxSalaryWorkers(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException {
        try {
            String sql = String.join("\n",
                    Files.readAllLines(
                            Paths.get(
                                    new Prefs()
                                            .getString(
                                                    Prefs.YOUNGEST_ELDEST_WORKERS)))
            );
            return database.findYoungestEldestWorkers(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProjectPrices> findProjectPrices() throws SQLException {
        try {
            String sql = String.join("\n",
                    Files.readAllLines(
                            Paths.get(
                                    new Prefs()
                                            .getString(
                                                    Prefs.PROJECT_PRICES)))
            );
            return database.findProjectPrices(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
