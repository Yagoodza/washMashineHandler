INSERT INTO wash_program (program, temperature, max_Load, maxrpm, work_Time, fabric_Type, description)
VALUES ('synthetics', 40, 6, 1000, 90, 'cotton', 'description'),
       ('synthetics', 40, 6, 1000, 90, 'cotton', 'description'),
       ('synthetics', 40, 6, 1000, 90, 'cotton', 'description');

INSERT INTO state (WASH_PROGRAM_ID, END_TIME, IS_BUSY) VALUES (2, '2021-06-04 22:00:00', 'TRUE' )