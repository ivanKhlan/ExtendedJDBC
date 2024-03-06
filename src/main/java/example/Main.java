package example;


import database.Database;
import inittable.InitTable;
import populate.DatabasePopulateService;
import requests.DatabaseQueryService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        Database database = Database.getInstance();

        new InitTable(database);

        DatabasePopulateService dps = new DatabasePopulateService(database);

        dps.createNewWorker(
                "Olivia",
                LocalDate.now().minusYears(30),
                "Trainee",
                500
        );
        dps.createNewClient("oracle");
        dps.createNewProject(1,
                LocalDate.now().minusYears(24),
                LocalDate.now().minusYears(23)
        );

        dps.createNewProjectWorker(1, 1);

        System.out.println(new DatabaseQueryService().findMaxProjectsClient());
        System.out.println(new DatabaseQueryService().findLongestProject());
        System.out.println(new DatabaseQueryService().findMaxSalaryWorkers());
        System.out.println(new DatabaseQueryService().findYoungestEldestWorkers());
        System.out.println(new DatabaseQueryService().findProjectPrices());
    }
}