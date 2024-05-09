INSERT INTO participant( name, created, email, phone )
    values ('Amr', now(), 'amr@gmail.com','123456789' ),
            ('Youssef', now(), 'youssef@gmail.com','0559134025' ),
            ('Rawda', now(), 'rawda@gmail.com','251144545'),
            ('Jinny', now(), 'jinny@gmail.com','0670868514' ),
            ('Omar', now(), 'omar@gmail.com','054123455' ),
            ('Mark', now(), 'mark@gmail.com','0123456702' ),
            ('zoltan', now(), 'zoltan@gmail.com','1420231452' ),
            ('Raze', now(), 'raze@gmail.com','1254214526'),
            ('Reyna', now(), 'reyna@gmail.com','023154212'),
            ('Gekko', now(), 'gekko@gmail.com','021254566'),
            ('Yoru', now(), 'yoru@gmail.com','125454875');

INSERT INTO host(name, created, email)
    values ('Amr', CURRENT_DATE(), 'amr@gmail.com'/*, (select id from participant where name='Amr')*/),
           ('Rawda', CURRENT_DATE(), 'rawda@gmail.com'/*, (select id from participant where name='Rawda')*/),
           ('Raze', CURRENT_DATE(), 'raze@gmail.com'),
           ('Reyna', CURRENT_DATE(), 'reyna@gmail.com'),
           ('Gekko', CURRENT_DATE(), 'gekko@gmail.com'),
           ('Yoru', CURRENT_DATE(), 'yoru@gmail.com');

INSERT INTO activity(name, created, description, date, location, host_id )
    values ('Picnic', now(), 'a nice event', '2024-03-06 22:00:00', 'orfu',(select id from host where name='Amr')),
            ('Drawing', now(), 'a really nice event', '2024-03-20 19:00:00', 'city center',(select id from host where name='Rawda')),
           ('Egg Hunting', now(), 'we will collect colorful eggs', '2024-05-06 9:00:00', 'Pecs',(select id from host where name='Gekko')),
           ('Fishing', now(), 'Lets catch some nice fish', '2024-10-20 9:00:00', 'Balaton',(select id from host where name='Raze')),
           ('Football', now(), 'we will have fun playing a competitive sport', '2024-07-12 13:00:00', 'Arena',(select id from host where name='Reyna')),
           ('Volleyball', now(), 'A nice sport activity for students', '2024-05-14 22:00:00', 'gym',(select id from host where name='Yoru'));

INSERT INTO part_act(part_id, act_id)
    values ((select id from participant where email='amr@gmail.com'),(select id from activity where name = 'Picnic')),
           ((SELECT id FROM participant WHERE email='youssef@gmail.com'),(SELECT id FROM activity WHERE name = 'Picnic')),
           ((SELECT id FROM participant WHERE email='rawda@gmail.com'),(SELECT id FROM activity WHERE name = 'Drawing')),
           ((SELECT id FROM participant WHERE email='jinny@gmail.com'),(SELECT id FROM activity WHERE name = 'Egg Hunting')),
           ((SELECT id FROM participant WHERE email='youssef@gmail.com'),(SELECT id FROM activity WHERE name = 'Egg Hunting')),
           ((SELECT id FROM participant WHERE email='gekko@gmail.com'),(SELECT id FROM activity WHERE name = 'Egg Hunting')),
           ((SELECT id FROM participant WHERE email='mark@gmail.com'),(SELECT id FROM activity WHERE name = 'Fishing')),
           ((select id from participant where email='zoltan@gmail.com'),(select id from activity where name = 'Drawing')),
           ((select id from participant where email='zoltan@gmail.com'),(select id from activity where name = 'Football')),
           ((select id from participant where email='raze@gmail.com'),(select id from activity where name = 'Fishing')),
           ((select id from participant where email='reyna@gmail.com'),(select id from activity where name = 'Football')),
           ((select id from participant where email='omar@gmail.com'),(select id from activity where name = 'Volleyball')),
           ((select id from participant where email='yoru@gmail.com'),(select id from activity where name = 'Volleyball'));