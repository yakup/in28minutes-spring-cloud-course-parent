insert into user values(1000, sysdate(), 'AB');
insert into user values(1001, sysdate(), 'Jack');
insert into user values(1002, sysdate(), 'Jill');

insert into post(id, description, user_id) values (2000, 'My first post', 1000);
insert into post(id, description, user_id) values (2001, 'My second post', 1001);
insert into post(id, description, user_id) values (2002, 'My third post', 1002);