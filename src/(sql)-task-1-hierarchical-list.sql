SELECT lpad(' ', 3*level)||name as Tree
FROM test_table
START WITH ParentID = 0
CONNECT BY PRIOR id = ParentID
ORDER SIBLINGS BY ParentID;

