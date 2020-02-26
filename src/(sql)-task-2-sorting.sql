SELECT lpad(' ', 3*level)||name as TreeTable
  FROM (
    SELECT distinct *
      FROM test_table t
     START WITH name LIKE '%a%'
       and not exists(select 1 from test_table x where x.parentId = t.id)
   CONNECT BY id = PRIOR ParentID
  ) x
   START WITH ParentID = 0
 CONNECT BY PRIOR id = ParentID
 ORDER SIBLINGS BY ParentId;