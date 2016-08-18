-- Busque o nome de todas as cidades que começam com 'Ara'

SELECT nome FROM tb_cidades
WHERE nome LIKE 'ARA%';

-- Busque o nome de todas as cidades do estado de São Paulo

SELECT nome FROM tb_cidades
WHERE id_estado = 26;

SELECT c.nome FROM tb_cidades c, tb_estados e
WHERE c.id_estado = e.id
AND e.nome = 'São Paulo';

SELECT c.nome FROM tb_cidades c
INNER JOIN tb_estados e ON e.id = c.id_estado
WHERE e.nome = 'São Paulo';

SELECT c.nome FROM tb_cidades c
INNER JOIN tb_estados e ON e.id = c.id_estado
WHERE e.id = 26;

-- Busque o nome e UF de todas as cidades da região sudeste (Espírito Santo, 
-- Minas Gerais, Rio de Janeiro e São Paulo)

SELECT c.nome, e.uf FROM tb_cidades c
INNER JOIN tb_estados e ON e.id = c.id_estado
WHERE e.id = 8 OR e.id = 11 OR e.id = 19 OR e.id = 26;

SELECT c.nome, e.uf FROM tb_cidades c
INNER JOIN tb_estados e ON e.id = c.id_estado
WHERE e.id IN (8, 11, 19, 26);

-- Busque a quantidade de cidades considerando todos os estados

SELECT COUNT(*) FROM tb_cidades;

-- Busque a quantidade de cidades da região sudeste

SELECT COUNT(*) FROM tb_cidades c
INNER JOIN tb_estados e ON e.id = c.id_estado
WHERE e.id IN (8, 11, 19, 26);

-- Busque todas as cidades com nome composto. Por exemplo: Santa Lúcia, 
-- Nova Europa, Américo Brasiliense etc.

SELECT * FROM tb_cidades
WHERE nome LIKE '% %';