SELECT lpad(' ', 3*level)||name as TreeTable
FROM test_table
WHERE name LIKE '%a%'
START WITH ParentID = 0
CONNECT BY PRIOR id = ParentID
ORDER SIBLINGS BY ParentID;