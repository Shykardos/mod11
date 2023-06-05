INSERT INTO clients (name) VALUES
    ('Баба Яга'),
    ('Балу'),
    ('Король Лев'),
    ('Зоня Добрянська'),
    ('Деніал Крейг'),
    ('Віталій Кличко'),
    ('Дональд Дак'),
    ('Моряк Папай'),
    ('Моніка'),
    ('Харлі Квін');

INSERT INTO planets (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn'),
    ('URAN', 'Uranus');

INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id) VALUES
    (CURRENT_TIMESTAMP, 1, 'MARS', 'VEN'),
    (CURRENT_TIMESTAMP, 2, 'VEN', 'MARS'),
    (CURRENT_TIMESTAMP, 3, 'JUP', 'SAT'),
    (CURRENT_TIMESTAMP, 4, 'SAT', 'JUP'),
    (CURRENT_TIMESTAMP, 5, 'URAN', 'VEN'),
    (CURRENT_TIMESTAMP, 6, 'MARS', 'URAN'),
    (CURRENT_TIMESTAMP, 7, 'URAN', 'MARS'),
    (CURRENT_TIMESTAMP, 8, 'VEN', 'SAT'),
    (CURRENT_TIMESTAMP, 9, 'JUP', 'MARS'),
    (CURRENT_TIMESTAMP, 10, 'SAT', 'VEN');