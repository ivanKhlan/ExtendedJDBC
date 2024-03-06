package database;

import initclasses.*;
import prefs.Prefs;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private PreparedStatement createSt;
    private Database() {

        try {
            connection = DriverManager.getConnection(new Prefs().getString(Prefs.DB_URL));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<MaxProjectCountClient> findMaxProjectsClient(String sql) throws SQLException {
        List<MaxProjectCountClient> result = new ArrayList<>();
        createSt = connection.prepareStatement(sql);

        ResultSet rs = createSt.executeQuery();

        while (rs.next()) {
            MaxProjectCountClient maxProjectCountClient =
                    new MaxProjectCountClient(rs.getString("name"),
                            rs.getInt("project_count")
                    );
            result.add(maxProjectCountClient);
        }

        return result;
    }


    public List<LongestProject> findLongestProject(String sql) throws SQLException {
        List<LongestProject> result = new ArrayList<>();
        createSt = connection.prepareStatement(sql);

        ResultSet rs = createSt.executeQuery();
        while (rs.next()) {
            LongestProject maxProjectCountClient =
                    new LongestProject(rs.getString("name"),
                            rs.getInt("month_count")
                    );
            result.add(maxProjectCountClient);
        }

        return result;
    }

    public List<MaxSalaryWorkersCount> findMaxSalaryWorkers(String sql) throws SQLException {
        List<MaxSalaryWorkersCount> result = new ArrayList<>();
        createSt = connection.prepareStatement(sql);

        ResultSet rs = createSt.executeQuery();
        while (rs.next()) {
            MaxSalaryWorkersCount maxSalaryWorkersCount =
                    new MaxSalaryWorkersCount(rs.getString("name"),
                            rs.getInt("salary")
                    );
            result.add(maxSalaryWorkersCount);
        }
        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers(String sql) throws SQLException {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        createSt = connection.prepareStatement(sql);

        ResultSet rs = createSt.executeQuery();
        while (rs.next()) {
            YoungestEldestWorkers youngestEldestWorkers =
                    new YoungestEldestWorkers(rs.getString("type"),
                            rs.getString("name"), LocalDate.parse(rs.getString("birthday"))
                    );
            result.add(youngestEldestWorkers);
        }
        return result;

    }

    public List<ProjectPrices> findProjectPrices(String sql) throws SQLException {
        List<ProjectPrices> result = new ArrayList<>();
        createSt = connection.prepareStatement(sql);

        ResultSet rs = createSt.executeQuery();
        while (rs.next()) {
            ProjectPrices projectPrices =
                    new ProjectPrices(rs.getString("name"),
                            rs.getInt("price")
                    );
            result.add(projectPrices);
        }
        return result;

    }

}
