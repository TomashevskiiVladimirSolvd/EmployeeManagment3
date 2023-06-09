USE `EmployeeManagementSystem`;
-- SELEST ALL FOR  TABLES:
Select * FROM contacts;
Select * FROM  departments ;
Select * FROM employees_departments;
Select * FROM employees;
Select * FROM employees_tasks ;
Select * FROM employees_skills ;
Select * FROM projects;
Select * FROM credentials;
Select * FROM tasks;
Select * FROM skills;
Select * FROM training_programs;
Select * FROM employees_trainings;

-- INSERT FOR  TABLES:

INSERT INTO employees (name, position)
VALUES 
  ('Jonh Wane', 'Sales Manager'),
  ('Joe Jonson',  'Junior Market Manager'),
  ('Bud Jackson',  'Senior Developer'),
  ('Fred Kort',  'Head of Development Team'),
  ('Buster Kiton', 'Developer'),
  ('Bucks Bunny',  'Junior Developer');
  
  INSERT INTO skills (name)
VALUES 
   ('leadership'),
   ('Communication'),
   ('Problem-solving ');
  
  INSERT INTO employees_skills(employee_id,skill_id,proficiency_level)
  VALUES
  (1,2,'Intermediate'),
  (2,2,'Beginner'),
  (3,1,'Advanced'),
  (4,1,'Advanced'),
  (5,1,'Medium'),
  (6,3,'Beginner');
  
INSERT INTO projects (name)
VALUES 
   ('Sales Analytics'),
   ('Market Research '),
   ('Social Media '),
   ('Social Media 2');
  
INSERT INTO credentials(employee_id,login,password)
VALUES
(1,'log1','pas1'),
(2,'log2','pas2'),
(3,'log3','pas3'),
(4,'log4','pas4'),
(5,'log5','pas5'),
(6,'log6','pas6');

INSERT INTO training_programs (name)
VALUES 
   ('TP1'),
   ('TP2'),
   ('TP3'),
   ('TP4'),
   ('TP5'),
   ('TP6');
 
INSERT INTO contacts (email,phone,employee_id)
VALUES 
   ('buddy12@gmail.com','+7 915 310 55 66',1),
   ('Frog55@gmail.com','+1 915 310 55 66',2),
   ('Filin@gmail.com','+3 956 370 85 96',3),
   ('genius12@gmail.com','+7 967 311 59 64',4),
   ('Brain45@gmail.com','+1 994 312 57 65',5),
   ('soSmart88@gmail.com','+3 936 373 84 99',6);
   
INSERT INTO departments (name)
VALUES 
   ('Sales'),
   ('Marketing'),
   ('IT');
   
INSERT INTO employees_departments (employee_id,department_id)
VALUES
(1,1),
(2,2),
(3,3),
(4,3),
(5,3),
(6,3);

INSERT INTO employees_trainings (programs_id,status,employee_id)
VALUES 
   (1,'In progress',2),
   (2,'Done',3),
   (3,'On hold',1),
   (4,'Cancelled',5),
   (5,'In progress',6),
   (6,'Done',4);
   

INSERT INTO tasks (name,priority,project_id)
VALUES 
   ('Analyze market trends','high',2),
   ('Data collection','low',3),
   ('Develop sales','medium',1),
   ('Data analyse','low',4);
   
INSERT INTO employees_tasks (employee_id,task_id,percentage_completed)
VALUES 
   (1,3,30),
   (2,1,40),
   (3,2,50),
   (4,4,30),
   (5,4,40),
   (6,4,60);

   
-- 5 ALTER TABLE AND 10 UPDATE  FOR  TABLES:
ALTER TABLE employees
ADD COLUMN gender VARCHAR(6);

ALTER TABLE employees
ADD salary INT;

Update employees 
SET gender = 'MALE', salary = 20000 
WHERE id =1;

Update employees 
SET gender = 'FEMALE',salary = 15000 
WHERE id = 2;

Update employees 
SET gender = 'MALE',salary = 30000
WHERE id = 3;

Update employees 
SET gender = 'MALE', salary = 35000
WHERE id = 4;

Update employees 
SET gender = 'MALE',salary = 25000
WHERE id = 5;

Update employees 
SET gender = 'MALE',salary = 20000
WHERE id = 6;


ALTER TABLE contacts
ADD COLUMN fax VARCHAR(45);

UPDATE contacts
SET fax = '123456789'
WHERE email = 'buddy12@gmail.com';

UPDATE contacts
SET fax = '678594032'
WHERE phone = '+1 915 310 55 66';

UPDATE contacts
SET fax = '987654321'
WHERE email = 'Filin@gmail.com' AND phone ='+3 956 370 85 96' ;

UPDATE contacts
SET fax = '987654345'
WHERE id = 4;

UPDATE contacts
SET fax = '656474854'
WHERE id = 5;

UPDATE contacts
SET fax = '383945950'
WHERE id = 6;

ALTER TABLE employees
ADD bonus INT;

UPDATE employees
SET bonus = 3000
WHERE id <7;

ALTER TABLE training_programs
ADD duration_hours INT;

UPDATE training_programs
SET duration_hours = 40
WHERE id BETWEEN 1 AND 5;

UPDATE training_programs
SET duration_hours = 80
WHERE id >5;


-- JOIN FOR 12 TABLES(SHOW INFORMATION FROM ALL TABLES):

SELECT *
FROM employees e
JOIN contacts c ON e.id=c.employee_id
JOIN credentials cr ON e.id =cr.employee_id
JOIN employees_skills es ON e.id = es.employee_id
JOIN skills s ON s.id = es.skill_id
JOIN employees_trainings etr ON e.id = etr.employee_id
JOIN training_programs tp ON tp.id = etr.programs_id
JOIN employees_departments ed ON e.id = ed.employee_id
JOIN departments d ON d.id = ed.department_id
JOIN employees_tasks et ON e.id = et.employee_id
JOIN tasks t ON t.id = et.task_id
JOIN projects p ON p.id = t.project_id;



-- 5 JOIN:

-- EMPLOYEE CONTACT LIST:
SELECT e.id,e.name,e.position,c.email,c.phone,c.fax
FROM contacts c
JOIN employees e ON e.id = c.employee_id ;

-- EMPLOYEE TASK COMPLETION LIST:
SELECT  e.id,e.name,e.position,et.task_id,et.percentage_completed as '% completed'
FROM employees e
LEFT JOIN  employees_tasks et ON e.id = et.employee_id;

-- EMPLOYEE TRAINING STATUS LIST:
SELECT e.id,e.name,e.position,et.program_id,et.status
FROM employees e
RIGHT JOIN employees_trainings  et ON e.id = et.employee_id;

-- EMPLOYEE CREDENTIAL LIST:
SELECT e.id,e.name,e.position,cr.login,cr.password
FROM employees e
INNER JOIN credentials cr ON e.id = cr.employee_id;

--  PRIORITY LIST:
SELECT pr.name as project,t.name as task,t.priority
FROM projects pr
JOIN tasks t ON pr.id = t.project_id;


-- SELECT WITH GROUP BY (7 WITH AND 7 WITHOUT HAVING):

-- HOW MANY MALE AND FEMALE IN COMPANY:
SELECT gender, COUNT(*) AS employee_count
FROM employees
GROUP BY gender;

-- COUNT FOR EACH PRIORITY:
Select priority ,COUNT(*) as count_priority
FROM tasks
GROUP BY priority;

-- PERCENTAGE COMPLETED OF ALL TASKS:
SELECT  percentage_completed,COUNT(*) AS count_percentage
FROM employees_tasks
GROUP BY percentage_completed;


-- SALARY RANGES COUNTER 
SELECT salary ,COUNT(*) AS salary_count
FROM employees
GROUP BY salary;


-- POSITION'S COUNTER:
SELECT position, COUNT(*) AS employee_count
FROM employees
GROUP BY position;

-- NAME'S COUNTER IN ASCENDING ORDER:
SELECT name, COUNT(*) AS employee_count
FROM employees
GROUP BY name
ORDER BY name ASC;

-- HOW MANY EMPLOYEES USE gmail :
SELECT COUNT(*) as gmail_count 
FROM contacts 
GROUP BY email LIKE '%gmail.com';

-- HOW MANY MALES IN COMPANY:
SELECT gender, COUNT(*) AS employee_count
FROM employees
GROUP BY gender
HAVING gender='MALE';

-- PERCENTAGE COMPLETED MORE THAT 49%:
SELECT  percentage_completed,COUNT(*) AS count_percentage
FROM employees_tasks
GROUP BY percentage_completed
HAVING percentage_completed> 49;

-- HOW MANY FEMALES IN COMPANY:
SELECT gender, COUNT(*) AS employee_count
FROM employees
GROUP BY gender
HAVING gender='FEMALE';

-- HOW MANY DEVELOPERS IN COMPANY:
SELECT position, COUNT(*) AS employee_count
FROM employees
GROUP BY position
HAVING position LIKE '%Developer';

-- HOW MANY EMPLOYEE'S NAMES STARTS WITH 'J':
SELECT name, COUNT(*) AS employee_count
FROM employees
GROUP BY name
HAVING name LIKE 'J%';

-- HOW MANY EMPLOYEES HAVE SALARY MORE THAN 30000:
SELECT salary ,COUNT(*) AS salary_count
FROM employees
GROUP BY salary
HAVING salary >30000;

-- HOW MANY EMPLOYEES HAVE 20000 SALARY 
SELECT salary ,COUNT(*) AS salary_count
FROM employees
GROUP BY salary
HAVING salary = 20000;

-- ADDITIONAL SELECT:

-- HOW MANY PROJECTS ABOUT SOCIAL MEDIA:
SELECT * FROM projects
WHERE name REGEXP 'Social Media';

-- HOW MANY TASKS FOR WORKIN WITH DATA:   
SELECT * FROM tasks
WHERE name LIKE 'Data%';

-- 10 DELETE STATEMENTS:

DELETE FROM contacts
WHERE email = 'Frog55@gmail.com';

DELETE FROM contacts
WHERE phone = '+3 956 370 85 96';

DELETE FROM contacts
WHERE fax = '383945950';

DELETE FROM projects
WHERE name LIKE '%Research';

DELETE FROM skills
WHERE name LIKE 'C%';

DELETE FROM credentials
WHERE login IN('log1','log2');

DELETE FROM departments
WHERE name = 'IT';

DELETE FROM tasks
WHERE priority = 'lowest' OR priority = 'low';

DELETE FROM employees_trainings
WHERE status = 'Cancelled' AND employee_id = 5;

DELETE FROM employees
WHERE name REGEXP 'John';









