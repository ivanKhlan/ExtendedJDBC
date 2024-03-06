INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
('Olivia', '1910-01-01', 'Trainee', '500'),
('Emma', '1920-02-01', 'Junior', '1000'),
('Mia', '1930-03-01', 'Middle', '1500'),
('Sophia', '1940-04-01', 'Senior', '2000'),
('Zoey', '1950-05-01', 'Trainee', '2500'),
('Charlotte', '1960-06-01', 'Junior', '3000'),
('Amelia', '1970-07-01', 'Middle', '3500'),
('Aria', '1980-08-01', 'Senior', '4000'),
('Ava', '1990-09-01', 'Trainee', '4500'),
('Ella', '2000-10-01', 'Junior', '5000'),
('Nora', '2001-11-01', 'Middle', '5500'),
('Isabella', '2002-12-01', 'Senior', '6000');



INSERT INTO client (NAME) VALUES
('oracle'),
('softserve'),
('facebook'),
('ubisoft'),
('activision');


INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
(4, '2000-01-01', '2000-02-01'),
(3, '2000-01-01', '2000-03-01'),
(5, '2000-01-01', '2000-04-01'),
(1, '2000-01-01', '2000-05-01'),
(2, '2000-01-01', '2000-06-01'),
(3, '2000-01-01', '2000-07-01'),
(5, '2000-01-01', '2000-08-01'),
(2, '2000-01-01', '2000-09-01'),
(4, '2000-01-01', '2000-10-01'),
(1, '2000-01-01', '2000-11-01');


INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
(1,1),
(1,2),
(2,3),
(2,4),
(3,5),
(3,6),
(4,7),
(4,8),
(5,9),
(5,10);