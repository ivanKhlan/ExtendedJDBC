SELECT worker.NAME AS NAME, 
COUNT(project_worker.PROJECT_ID) AS PROJECT_COUNT
FROM worker
JOIN project_worker ON worker.ID = project_worker.WORKER_ID
GROUP BY worker.NAME;