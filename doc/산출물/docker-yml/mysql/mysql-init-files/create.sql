# create pb and grant privileges
create user pv@'%' identified by '1111';

CREATE DATABASE pb;

grant all privileges on *.* to pv@'%';

flush privileges;