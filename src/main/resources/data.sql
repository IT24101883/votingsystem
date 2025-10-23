-- Users
INSERT INTO users (id, name, email, password, role) VALUES
                                                        (1, 'Admin', 'admin@example.com', 'admin123', 'ADMIN'),
                                                        (2, 'Alice Nominee', 'alice@ex.com', 'pass', 'NOMINEE'),
                                                        (3, 'Bob Nominator', 'bob@ex.com', 'pass', 'NOMINATOR');

-- Categories
INSERT INTO award_category (id, name, description) VALUES
                                                       (1, 'Best Actor', 'Top actor of the year'),
                                                       (2, 'Best Movie', 'Top movie of the year');

-- Nominations
INSERT INTO nomination (id, nominee_id, category_id, description) VALUES
                                                                      (1, 2, 1, 'Alice for Best Actor'),
                                                                      (2, 2, 2, 'Alice’s Movie');

-- (Votes can be added via API)

