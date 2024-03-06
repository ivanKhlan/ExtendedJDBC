SELECT
    client.NAME,
    DATEDIFF('MONTH', project.START_DATE, project.FINISH_DATE) AS MONTH_COUNT
FROM
    project
JOIN
    client ON project.CLIENT_ID = client.ID
ORDER BY
    MONTH_COUNT DESC
LIMIT 1;