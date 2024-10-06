-- Correct SQL syntax with column names matching the entity

INSERT INTO currency (id, currency_from, currency_to, conv, environment)
VALUES (1001, 'USD', 'INR', 65, '');

INSERT INTO currency (id, currency_from, currency_to, conv, environment)
VALUES (1002, 'EUR', 'INR', 55, '');

INSERT INTO currency (id, currency_from, currency_to, conv, environment)
VALUES (1003, 'AUS', 'INR', 45, '');
