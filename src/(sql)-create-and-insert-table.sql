CREATE TABLE test_table (
  id INT,
  ParentId INT,
  Name VARCHAR(256));

INSERT INTO test_table VALUES (1, 0, 'debian');
INSERT INTO test_table VALUES (2, 1, 'ubuntu');
INSERT INTO test_table VALUES (3, 2, 'kubuntu');
INSERT INTO test_table VALUES (4, 2, 'lubuntu');
INSERT INTO test_table VALUES (5, 2, 'linux mint');
INSERT INTO test_table VALUES (6, 0, 'slackware');
INSERT INTO test_table VALUES (7, 6, 'slax');
INSERT INTO test_table VALUES (8, 7, 'wolvix');
INSERT INTO test_table VALUES (9, 7, 'slampp');
INSERT INTO test_table VALUES (10, 7, 'dnalinux');
INSERT INTO test_table VALUES (11, 6, 'suse');
INSERT INTO test_table VALUES (12, 11, 'linkat');
INSERT INTO test_table VALUES (13, 11, 'opensuse');
INSERT INTO test_table VALUES (14, 0, 'redhate');
INSERT INTO test_table VALUES (15, 14, 'fedora core');
INSERT INTO test_table VALUES (16, 15, 'sailfish os');
INSERT INTO test_table VALUES (17, 15, 'fedora');