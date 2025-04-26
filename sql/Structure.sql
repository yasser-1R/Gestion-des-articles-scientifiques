CREATE TABLE articles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    authors TEXT NOT NULL,
    journals TEXT NOT NULL,
    quartile VARCHAR(10),
    publication_date DATE NOT NULL,
    pdf_path TEXT
);