INSERT INTO tb_usuario(nome, email, login, senha, nivel_acesso) VALUES ('Luiz Henrique', 'Luiz@gmail.com', 'luiz', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'NIVEL1');
INSERT INTO tb_usuario(nome, email, login, senha, nivel_acesso) VALUES ('Pedro Lucas', 'Pedro@gmail.com', 'pedro', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'NIVEL2');
INSERT INTO tb_usuario(nome, email, login, senha, nivel_acesso) VALUES ('Maria Helena', 'Maria@gmail.com','maria', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'NIVEL2');
INSERT INTO tb_usuario(nome, email, login, senha, nivel_acesso) VALUES ('José Germano', 'Jose@gmail.com', 'jose',  '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6','NIVEL3');

INSERT INTO tb_categoria(descricao, tipo) VALUES ('Contas residenciais', 'Fixa');
INSERT INTO tb_categoria(descricao, tipo) VALUES ('Moradia', 'Fixa');
INSERT INTO tb_categoria(descricao, tipo) VALUES ('Educação', 'Fixa');
INSERT INTO tb_categoria(descricao, tipo) VALUES ('Compras', 'Variável');
INSERT INTO tb_categoria(descricao, tipo) VALUES ('Lazer', 'Variável');
INSERT INTO tb_categoria(descricao, tipo) VALUES ('Salário', 'Fixo');
INSERT INTO tb_categoria(descricao, tipo) VALUES ('Vale Alimentação', 'Fixo');

INSERT INTO tb_despesa(descricao, data_vencimento, data_pagamento, situacao, valor, id_usuario, id_categoria) VALUES ('Internet', '2025-06-05', '2025-06-05', 'paga', 1200.00, 1, 1);
INSERT INTO tb_despesa(descricao, data_vencimento, data_pagamento, situacao, valor, id_usuario, id_categoria) VALUES ('Conta de Água', '2025-06-10', '2025-06-09', 'paga', 85.75, 2, 2);
INSERT INTO tb_despesa(descricao, data_vencimento, data_pagamento, situacao, valor, id_usuario, id_categoria) VALUES ('Assinatura Netflix', '2025-06-20', '2025-06-21', 'pendente', 39.90, 3, 5);

INSERT INTO tb_receita(data_entrada, id_usuario, id_categoria, valor) VALUES ('2025-06-11', 3, 6, 1500.00);
INSERT INTO tb_receita(data_entrada, id_usuario, id_categoria, valor) VALUES ('2025-06-09', 1, 7, 600.00);
INSERT INTO tb_receita(data_entrada, id_usuario, id_categoria, valor) VALUES ('2025-06-09', 4, 6, 2000.00);
