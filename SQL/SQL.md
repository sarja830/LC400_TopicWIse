
## The Report

```mysql
/*
Enter your query here.
*/

Select
    CASE
        WHEN Grades.Grade>=8 THEN  Students.Name
        WHEN Grades.Grade<8 THEN NULL -- this is also correct
#         else NULL this is also correct
        END,
    Grades.Grade, Students.Marks
from Students, Grades where Marks>=Grades.Min_Mark and Marks<=Grades.Max_Mark
ORDER BY Grades.Grade Desc,
         CASE
             WHEN  Grades.Grade>=8   THEN   Students.Name
             WHEN Grades.Grade<8  THEN   Students.Marks
             END
        asc
```

## Top Competitors

```mysql
SELECT Hackers.hacker_id, Hackers.name
from Hackers
JOIN  Submissions ON Hackers.hacker_id = Submissions.hacker_id
JOIN  Challenges ON Submissions.challenge_id = Challenges.challenge_id
JOIN  Difficulty ON Difficulty.difficulty_level = Challenges.difficulty_level
WHERE Submissions.score = Difficulty.score
GROUP BY Hackers.hacker_id, Hackers.name
HAVING COUNT(Hackers.hacker_id) > 1
ORDER BY COUNT(Hackers.hacker_id) desc , Hackers.hacker_id asc;

```