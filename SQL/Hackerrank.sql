/*
Enter your query here.
*/

Select
    CASE/*
Enter your query here.
*/

Select
    CASE
        WHEN Grades.Grade>=8 THEN  Students.Name
-- WHEN Grades.Grade<8 THEN NULL this is also correct
        else NULL
        end,
    Grades.Grade, Students.Marks
from Students, Grades where Marks>=Grades.Min_Mark and Marks<=Grades.Max_Mark
ORDER BY Grades.Grade Desc,
         CASE
             WHEN  Grades.Grade>=8   THEN   Students.Name
             WHEN Grades.Grade<8  THEN   Students.Marks
             END
        asc
        WHEN Grades.Grade>=8 THEN  Students.Name
-- WHEN Grades.Grade<8 THEN NULL this is also correct
        else NULL
        end,
    Grades.Grade, Students.Marks
from Students, Grades where Marks>=Grades.Min_Mark and Marks<=Grades.Max_Mark
ORDER BY Grades.Grade Desc,
         CASE
             WHEN  Grades.Grade>=8   THEN   Students.Name
             WHEN Grades.Grade<8  THEN   Students.Marks
             END
        asc