SELECT project.ID AS NAME,
       SUM(worker.salary) * DATEDIFF('MONTH', project.START_DATE, project.FINISH_DATE) AS PRICE
FROM
    project
JOIN
    project_worker ON project.ID = project_worker.PROJECT_ID
JOIN
    worker ON project_worker.WORKER_ID = worker.ID
GROUP BY
    project.ID
ORDER BY
    project.ID;