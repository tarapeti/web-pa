DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS products cascade;
DROP TABLE IF EXISTS types_table cascade;
DROP TABLE IF EXISTS values_table cascade;
DROP TABLE IF EXISTS attributes_table cascade;
DROP TABLE IF EXISTS signatures cascade;
DROP TABLE IF EXISTS order_details cascade;
DROP TABLE IF EXISTS orders cascade;

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username TEXT        NOT NULL,
    email    TEXT UNIQUE NOT NULL,
    password TEXT        NOT NULL,
    role     BOOLEAN,
    CONSTRAINT email_not_empty CHECK (email <> ''),
    CONSTRAINT password_not_empty CHECK (password <> '')
);

create table types_table
(
    id   serial primary key,
    typename text
);

CREATE TABLE products
(
    id      SERIAL PRIMARY KEY,
    type_id int,
    name    text,
    brand   text,
    price   int,
    foreign key (type_id) references types_table (id)

);

create table attributes_table
(
    id             serial primary key,
    attribute_name text,
    value_type     text
);

create table values_table
(
    attribute_id int,
    product_id   int,
    value_int    int,
    value_string text,
    value_bool   boolean,
    foreign key (attribute_id) references attributes_table (id),
    foreign key (product_id) references products (id)
);



create table signatures
(
    pro_id   int,
    deck_id  int,
    grip_id  int,
    truck_id int,
    wheel_id int,
    foreign key (pro_id) references users (id),
    foreign key (deck_id) references products (id),
    foreign key (grip_id) references products (id),
    foreign key (truck_id) references products (id),
    foreign key (wheel_id) references products (id)
);


create table order_details
(
    order_id   SERIAL primary key,
    product_id int,
    price      int,
    date       bigint,
    foreign key (product_id) references products (id)

);

create table orders
(
    order_id    int,
    customer_id int,
    foreign key (order_id) references order_details (order_id),
    foreign key (customer_id) references users (id)
);

INSERT INTO users(username, email, password, role)
VALUES ('user1', 'user1@user1', 'user1', false),
       ('user2', 'user2@user2', 'user2', false),
       ('pro1', 'pro1@pro1', 'pro1', true),
       ('pro2', 'pro2@pro2', 'pro2', true);

INSERT INTO types_table(typename)
VALUES ('deck'),
       ('grip'),
       ('truck'),
       ('wheel'),
       ('other');

INSERT INTO products(type_id, name, brand, price)
VALUES (1, 'OG Logo Red Mini Deck', 'BLIND', 30),
       (2, 'Green/Yellow Griptape', 'Shake Junt', 10),
       (3, 'Black Widow Full Dip Scripts Truck', 'Thunder', 22),
       (4, 'Trippy OG Wheels', 'BLIND', 17),
       (1, 'Pro Deck', 'Pro', 100),
       (2, 'Pro Grip', 'Pro', 100),
       (3, 'Pro Truck', 'Pro', 100),
       (4, 'Pro Wheels', 'BLIND', 100);

INSERT INTO attributes_table(attribute_name, value_type)
VALUES ('width', 'integer'),
       ('weight', 'int'),
       ('color', 'string'),
       ('diameter', 'int');

INSERT INTO values_table(attribute_id, product_id, value_int, value_string, value_bool)
VALUES (1, 1, 7, null, null),
       (2, 3, 700, null, null),
       (2, 2, 7, null, null),
       (1, 3, 150, null, null),
       (4, 4, 52, null, null),
       (1, 5, 8, null, null),
       (3, 6, 0, 'red', null),
       (2, 7, 10, null, null),
       (4, 8, 50, null, null);

INSERT INTO signatures(pro_id, deck_id, grip_id, truck_id, wheel_id) values (3, 5, 6, 7, 8);
