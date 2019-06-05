DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS types_table;
DROP TABLE IF EXISTS values_table;
DROP TABLE IF EXISTS attributes_table;
DROP TABLE IF EXISTS signatures;
DROP TABLE IF EXISTS order_details;
DROP TABLE IF EXISTS orders;

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


CREATE TABLE products
(
    id      SERIAL PRIMARY KEY,
    type_id int,
    name    text,
    brand   text,
    price   int,
    foreign key (type_id) references types_table (id)

);

create table types_table
(
    id   serial primary key,
    name text
);

create table values_table
(
    attribute_id int,
    value_int    int,
    value_string text,
    value_bool   boolean,
    foreign key (attribute_id) references attributes_table (id)
);

create table attributes_table
(
    id             serial primary key,
    attribute_name text,
    value_type     text
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

create table orders
(
    order_id    int,
    customer_id int,
    foreign key (order_id) references order_details (order_id),
    foreign key (customer_id) references users (id)
);

create table order_details
(
    order_id   int,
    product_id int,
    quantity   int,
    price      int,
    date       date,
    foreign key (product_id) references products (id)

);
