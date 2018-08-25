INSERT into attendee values (1001, 'Joe');
INSERT into attendee values (1002, 'Steve');
INSERT into attendee values (1003, 'Sally');
INSERT into attendee values (1004, 'Katie');


INSERT into session values (1001, 'Spring');
INSERT into session values (1002, 'React');
INSERT into session values (1003, 'NiFi');

INSERT into attendee_session values (1001, 1001, 1001);
INSERT into attendee_session values (1002, 1001, 1002);
INSERT into attendee_session values (1003, 1001, 1003);
INSERT into attendee_session values (1004, 1002, 1002);
INSERT into attendee_session values (1005, 1003, 1001);
INSERT into attendee_session values (1006, 1003, 1003);
INSERT into attendee_session values (1007, 1004, 1001);
INSERT into attendee_session values (1008, 1004, 1002);
INSERT into attendee_session values (1009, 1004, 1003);
